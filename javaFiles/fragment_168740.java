al.add("ffmpeg");
al.add("-i"); // input file
al.add(videoSrcPath); 
al.add("-i"); // input file 2
al.add(videoSrcPath2);
al.add("-filter_complex");
al.add("[0:0] [0:1] [1:0] [1:1] concat=n=2:v=1:a=1 [v] [a]");
al.add("-map");
al.add("[v]");
al.add("-map");
al.add("[a]");
al.add("-strict");
al.add("-2");
al.add("-preset");
al.add("ultrafast");
al.add(outputFilePath); // output file at end of string

String[] ffmpegCommand = al.toArray(new String[al.size()]);
vk.run(ffmpegCommand, workFolder, appContext);