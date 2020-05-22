private void segmentFile(String input, String output, int hls_start,
      int hls_time, int hls_list_size, int hls_wrap, String hls_base_url,
      String vFilter,
      String aFilter) throws InterruptedException, IOException {

    JNIMemoryManager.getMgr().setMemoryDebugging(true);


    Demuxer demuxer = Demuxer.make();

    demuxer.open(input, null, false, true, null, null);

    // we're forcing this to be HTTP Live Streaming for this demo.
    Muxer muxer = Muxer.make(output, null, "hls");
    muxer.setProperty("start_number", hls_start);
    muxer.setProperty("hls_time", hls_time);
    muxer.setProperty("hls_list_size", hls_list_size);
    muxer.setProperty("hls_wrap", hls_wrap);
    if (hls_base_url != null && hls_base_url.length() > 0)
      muxer.setProperty("hls_base_url", hls_base_url);

    MuxerFormat format = MuxerFormat.guessFormat("mp4", null, null);

    /**
     * Create bit stream filters if we are asked to.
     */
    BitStreamFilter vf = vFilter != null ? BitStreamFilter.make(vFilter) : null;
    BitStreamFilter af = aFilter != null ? BitStreamFilter.make(aFilter) : null;

    int n = demuxer.getNumStreams();
    DemuxerStream[] demuxerStreams = new DemuxerStream[n];
    Decoder[] decoders = new Decoder[n];
    List<MuxerStream> muxerStreamList = new ArrayList();
    for(int i = 0; i < n; i++) {
      demuxerStreams[i] = demuxer.getStream(i);
      decoders[i] = demuxerStreams[i].getDecoder();
      Decoder d = decoders[i];

      if (d != null) {
        // neat; we can decode. Now let's see if this decoder can fit into the mp4 format.
        if (!format.getSupportedCodecs().contains(d.getCodecID())) {
          throw new RuntimeException("Input filename (" + input + ") contains at least one stream with a codec not supported in the output format: " + d.toString());
        }
        if (format.getFlag(MuxerFormat.Flag.GLOBAL_HEADER))
          d.setFlag(Coder.Flag.FLAG_GLOBAL_HEADER, true);
        d.open(null, null);
        muxerStreamList.add(muxer.addNewStream(d));
      }
    }
    muxer.open(null, null);

    n = muxer.getNumStreams();
    MuxerStream[] muxerStreams = new MuxerStream[n];
    Coder[] coder = new Coder[n];
    for (int i = 0; i < n; i++) {
        muxerStreams[i] = muxer.getStream(i);
        if (muxerStreams[i] != null) {
            coder[i] = muxerStreams[i].getCoder();
        }
    }

    MediaPacket packet = MediaPacket.make();

    while(demuxer.read(packet) >= 0) {
      /**
       * Now we have a packet, but we can only write packets that had decoders we knew what to do with.
       */
      final Decoder d = decoders[packet.getStreamIndex()];
      if (packet.isComplete() && d != null) {
        // check to see if we are using bit stream filters, and if so, filter the audio
        // or video.
        if (vf != null && d.getCodecType() == Type.MEDIA_VIDEO)
          vf.filter(packet, null);
        else if (af != null && d.getCodecType() == Type.MEDIA_AUDIO)
          af.filter(packet, null);

        muxer.write(packet, false);

      }
    }



    // It is good practice to close demuxers when you're done to free
    // up file handles. Humble will EVENTUALLY detect if nothing else
    // references this demuxer and close it then, but get in the habit
    // of cleaning up after yourself, and your future girlfriend/boyfriend
    // will appreciate it.

    muxer.close();
    demuxer.close();

    muxer.delete();
    demuxer.delete();
    packet.delete();
    format.delete();
    vf.delete();

    muxer = null;
    demuxer = null;
    packet = null;
    format = null;
    vf = null;

    for (int i=0; i < muxerStreams.length; i++) {
        if (muxerStreams[i] != null) {
            muxerStreams[i].delete();
            muxerStreams[i] = null;
        }
        if (coder[i] != null) {
            coder[i].delete();
            coder[i] = null;
        }
    }

    for (int i=0; i < demuxerStreams.length; i++) {
        if (demuxerStreams[i] != null) {
            demuxerStreams[i].delete();
            demuxerStreams[i] = null;
        }
        if (decoders[i] != null) {
            decoders[i].delete();
            decoders[i] = null;
        }
    }

    for (Iterator iterator = muxerStreamList.iterator(); iterator.hasNext();) {
        MuxerStream muxerStream = (MuxerStream) iterator.next();
        if (muxerStream != null) {
            muxerStream.delete();
            muxerStream = null;
        }
    }
    muxerStreamList.clear();
    muxerStreamList = null;

    System.out.println("number of alive objects:" + JNIMemoryManager.getMgr().getNumPinnedObjects());


  }