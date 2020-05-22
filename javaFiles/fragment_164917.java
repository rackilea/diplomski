String text = "http:\\/\\/www.video.mediaset.it\\/bin\\/635.$plit\\/640x360_C_2_video_772135_videoThumbnail.jpg";
try {
    String afterDecode = URLDecoder.decode(text, "UTF-8");
    Log.e("text", afterDecode);
} catch (UnsupportedEncodingException e) {
    e.printStackTrace();
}