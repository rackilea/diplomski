int chunkSize = videoDurationSecs/(numberOfChunks + 1);
        int startSecs = 0;
        for (int i=0; i<numberOfChunks; i++) {
            //Create video chunk
            String startTime = convertSecsToTimeString(startSecs);
            int endSecs = startSecs + ((i+1)*chunkSize);
            if (endSecs > videoDurationSecs) {
                //make sure rounding does not mean we go beyond end of video
                endSecs = videoDurationSecs;
            }
            String endTime = convertSecsToTimeString(endSecs);

            //Call ffmpeg to create this chunk of the video using a ffmpeg wrapper
            String argv[] = {"ffmpeg", "-i", videoPath, 
                    "-ss",startTime, "-t", endTime,
                    "-c","copy", segmentVideoPath[i]};
            int ffmpegWrapperReturnCode = ffmpegWrapper(argv);
        }


        String convertSecsToTimeString(int timeSeconds) {
            //Convert number of seconds into hours:mins:seconds string
            int hours = timeSeconds / 3600;
            int mins = (timeSeconds % 3600) / 60;
            int secs = timeSeconds % 60;
            String timeString = String.format("%02d:%02d:%02d", hours, mins, secs);
            return timeString;
        }