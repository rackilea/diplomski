public static void main(String[] args) throws IOException {

    String audioDeutsch = MuxMp4SourcesExample.class.getProtectionDomain().getCodeSource().getLocation().getFile() + "/count-deutsch-audio.mp4";
    String audioEnglish = MuxMp4SourcesExample.class.getProtectionDomain().getCodeSource().getLocation().getFile() + "/count-english-audio.mp4";
    String video = MuxMp4SourcesExample.class.getProtectionDomain().getCodeSource().getLocation().getFile() + "/count-video.mp4";


    Movie countVideo = MovieCreator.build(new FileInputStream(video).getChannel());
    Movie countAudioDeutsch = MovieCreator.build(new FileInputStream(audioDeutsch).getChannel());
    Movie countAudioEnglish = MovieCreator.build(new FileInputStream(audioEnglish).getChannel());

    Track audioTrackDeutsch = countAudioDeutsch.getTracks().get(0);
    audioTrackDeutsch.getTrackMetaData().setLanguage("deu");
    Track audioTrackEnglish = countAudioEnglish.getTracks().get(0);
    audioTrackEnglish.getTrackMetaData().setLanguage("eng");

    countVideo.addTrack(audioTrackDeutsch);
    countVideo.addTrack(audioTrackEnglish);

    Container out = new DefaultMp4Builder().build(countVideo);
    FileOutputStream fos = new FileOutputStream(new File("output.mp4"));
    out.writeContainer(fos.getChannel());
    fos.close();

}