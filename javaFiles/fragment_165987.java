final IMediaWriter oggWriter = ToolFactory.makeWriter(oggOutputFile);

// Using stream 1 'cause there is also a video stream.
// For an audio only file you should use stream 0.
oggWriter.addAudioStream(1, 1, ICodec.ID.CODEC_ID_VORBIS, 
                         audioCoder.getChannels(), audioCoder.getSampleRate());