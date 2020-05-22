private void mergeSongs() throws Exception {
        File merge = new File(mFileNameToUse);
        String f1 = mFileNameFromRec;
        String f2 = mFileNameToUse;
        if (!merge.exists()) {

            InputStream in = new FileInputStream(new File(f1));
            OutputStream out = new FileOutputStream(new File(f2));

            // Transfer bytes from in to out
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
            Log.d("audio concatenation", "was copied");

        } else {

            Movie[] inMovies;

            inMovies = new Movie[] { MovieCreator.build(f2),
                    MovieCreator.build(f1), };

            List<Track> videoTracks = new LinkedList<Track>();
            List<Track> audioTracks = new LinkedList<Track>();

            for (Movie m : inMovies) {
                for (Track t : m.getTracks()) {
                    if (t.getHandler().equals("soun")) {
                        audioTracks.add(t);
                    }
                    if (t.getHandler().equals("vide")) {
                        videoTracks.add(t);
                    }
                }
            }

            Movie result = new Movie();
            if (videoTracks.size() > 0) {
                result.addTrack(new AppendTrack(videoTracks
                        .toArray(new Track[videoTracks.size()])));
            }

            if (audioTracks.size() > 0) {
                result.addTrack(new AppendTrack(audioTracks
                        .toArray(new Track[audioTracks.size()])));
            }

            Container out = new DefaultMp4Builder().build(result);

            RandomAccessFile ram = new RandomAccessFile(String.format(context
                    .getCacheDir() + "/output.mp4"), "rw");
            FileChannel fc = ram.getChannel();
            out.writeContainer(fc);
            ram.close();
            fc.close();
            // IsoFile out = (IsoFile) new DefaultMp4Builder().build(result);
            // FileOutputStream fos = new FileOutputStream(new File(
            // String.format(context.getCacheDir() + "/output.mp4")));
            // out.getBox(fos.getChannel());
            // fos.close();
            String mergedFilepath = String.format(context.getCacheDir()
                    + "/output.mp4");

            copy(new File(mergedFilepath), new File(mFileNameToUse));
            Toast.makeText(getApplicationContext(), "success",
                    Toast.LENGTH_SHORT).show();
        }
    }