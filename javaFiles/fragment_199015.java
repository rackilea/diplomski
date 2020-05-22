@Override
public void call(Object... args) {

     imageId.add("https://static.pexels.com/photos/247932/pexels-photo-
     247932.jpeg");

     imageId.add("https://static.pexels.com/photos/247932/pexels-photo-
     247932.jpeg");

     imageId.add("https://static.pexels.com/photos/247932/pexels-photo-
     247932.jpeg");

     imageId.add("https://static.pexels.com/photos/247932/pexels-photo-
     247932.jpeg");

     imageAdapter2 = new ImageAdapter2(getActivity(), imageId);
     gridView.setAdapter(imageAdapter2);
}