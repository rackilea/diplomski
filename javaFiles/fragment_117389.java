String[] command = { ffmpegLoc+"ffmpeg.exe",
                     "-i", dir+params.getString(4)+".flv",
                     "-copyts",
                     "-crf", "18",
                     "-profile:v", "baseline",
                     "-level", "3.0",
                     "-pix_fmt", "yuv420p",
                     "-preset", "veryslow",
                     dir+params.getString(4)+".mp4"};