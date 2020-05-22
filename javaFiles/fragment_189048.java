FfmpegController ffmpegController = new FfmpegController(appContext, appContext.getCacheDir());
TranscodeCallback tcCallback = new TranscodeCallback();

ArrayList<Clip> listVideos = new ArrayList<Clip>();

Clip clip = new Clip();
clip.path = new File(videoSrcPath).getCanonicalPath();
ffmpegController.getInfo(clip);
clip.duration = 5;
listVideos.add(clip);

Clip clip2 = new Clip();
clip2.path = new File(videoSrcPath2).getCanonicalPath();
ffmpegController.getInfo(clip2);
clip2.duration = 5;
listVideos.add(clip2);

Clip clip3 = new Clip();
clip3.path = new File(videoSrcPath3).getCanonicalPath();
ffmpegController.getInfo(clip3);
clip3.duration = 5;
listVideos.add(clip3);

Clip clipOut = new Clip();
clipOut.path = new File(outputFilePath).getCanonicalPath();

ffmpegController.concatAndTrimFilesMP4Stream(listVideos, clipOut, false, false, new ShellUtils.ShellCallback() {
    @Override
    public void shellOut(String shellLine) {
        System.out.println("fc>" + shellLine);
    }
    @Override
    public void processComplete(int exitValue) {
        if (exitValue < 0)
            System.err.println("concat non-zero exit: " + exitValue);
    }
});