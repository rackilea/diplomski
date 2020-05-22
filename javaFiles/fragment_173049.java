PhotoEntry returnedPhoto = myService.insert(feedUrl, PhotoEntry.class, myMedia);
String href = returnedPhoto.getHtmlLink().getHref();
if (returnedPhoto.getMediaContents().size() > 0) {
  href = returnedPhoto.getMediaContents().get(0).getUrl();
}
System.out.println(href);