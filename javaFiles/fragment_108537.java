// Get media, f.e. by code
MediaModel media = mediaService.getMedia("myMediaCode");
InputStream oldInputStream = mediaService.getStreamFromMedia(media);
// add your logic to add a line
InputStream newInputStream = ...;
mediaService.setStreamForMedia(media, newInputStream);