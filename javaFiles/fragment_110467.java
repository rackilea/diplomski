Library l = aList(i);
if(l instanceof PhotoLibrary) {
     PhotoLibrary pl = (PhotoLibrary)l;
     pl.displaySlideShow();
}
else if(l instanceof VideoLibrary) {
     VideoLibrary vl = (VideoLibrary)l;
     vl.playVideo();
}