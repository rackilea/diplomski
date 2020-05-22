String cmd[] = new String[]{
                "ffmpeg",
                "-r", String.valueOf(20/30f), 
                "-i", "assets/IMAG0054_BURST%03d.jpg",
                "-i","assets/logo.png",
                "-i","assets/guitar_tuning.wav","-r", "24", "-codec:a", "mp3",
                "-filter_complex","[0:v][1:v]overlay=main_w-overlay_w-10:main_h-overlay_h-10,"+
                "drawtext=fontfile=assets/OpenSans-Regular.ttf:text=1st scene:x=0:y=0:fontsize=100:fontcolor=white:enable='between(t,0.5,2.5)'," +
                "drawtext=enable='between(t,2.6,5.5)':fontfile=assets/OpenSans-Regular.ttf:text=2nd scene:x=0:y=0:fontsize=100:fontcolor=white," +
                "drawtext=enable='between(t,5.6,8.8)':fontfile=assets/OpenSans-Regular.ttf:text=3rd scene:x=0:y=0:fontsize=100:fontcolor=white," +
                "drawtext=enable='between(t,8.9,30)':fontfile=assets/OpenSans-Regular.ttf:text=4rd scene:x=0:y=0:fontsize=100:fontcolor=white" +
                "[out]",
                "-map", "[out]", "-map", "2:0",
                "-acodec","mp3",
                //"-shortest " +
                "simple_lapse.mp4"};

Process ffmpeg = Runtime.getRuntime().exec(cmd);