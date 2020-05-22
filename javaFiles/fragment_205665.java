AACTrackImpl aacTrack = new AACTrackImpl(new FileDataSourceImpl(RECORD));
            if (aacTrack.getSamples().size()>1000) {
                CroppedTrack aacTrackShort = new CroppedTrack(aacTrack, aacTrack.getSamples().size() - 1000, aacTrack.getSamples().size());
                Movie movie = new Movie();
                movie.addTrack(aacTrackShort);
                Container mp4file = new DefaultMp4Builder().build(movie);
                FileChannel fc = new FileOutputStream(new File(fileName)).getChannel();
                mp4file.writeContainer(fc);
                fc.close();
                aacTrackShort.close();
                aacTrack.close();