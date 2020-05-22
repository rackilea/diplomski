MovieCreator mc = new MovieCreator();
Movie video = mc.build(Channels.newChannel(AppendExample.class.getResourceAsStream("/count-video.mp4")));
Movie audio = mc.build(Channels.newChannel(AppendExample.class.getResourceAsStream("/count-english-audio.mp4")));


List<Track> videoTracks = video.getTracks();
video.setTracks(new LinkedList<Track>());

List<Track> audioTracks = audio.getTracks();


for (Track videoTrack : videoTracks) {
   video.addTrack(new AppendTrack(videoTrack, videoTrack));
}
for (Track audioTrack : audioTracks) {
   video.addTrack(new AppendTrack(audioTrack, audioTrack));
}

IsoFile out = new DefaultMp4Builder().build(video);
FileOutputStream fos = new FileOutputStream(new File(String.format("output.mp4")));
out.getBox(fos.getChannel());
fos.close();