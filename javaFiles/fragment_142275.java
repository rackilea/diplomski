public void upload()
{
try {
    Log.d("DDDDD", "uploading in background...");
    File audioFile = new File("/mnt/sdcard/Music/A1.mp3");
            // replace the hardcoded path with the path of your audio file
    audioFile.setReadable(true, false);
    HttpResponse resp = wrapper.post(Request.to(Endpoints.TRACKS)
            .add(Params.Track.TITLE, "A1.mp3")
            .add(Params.Track.TAG_LIST, "demo upload")
            .withFile(Params.Track.ASSET_DATA, audioFile));
    Log.i("......",""+Integer.valueOf(resp.getStatusLine().getStatusCode()));
    Log.d("DDDDD", "background thread done...");

} catch (IOException exp) {
    Log.d("DDDDD",
            "Error uploading audioclip: IOException: "
                    + exp.toString());

}
}