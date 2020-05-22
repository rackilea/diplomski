Map<String, List<Photo>> result = new HashMap<String, List<Photo>>();

while(data.hasMoreData()) {

  String name = data.getName();
  String photo = data.getPhoto();

  List<Photo> photos = result.get(name);
  if (photos == null) {
    photos = new ArrayList<Photo>();
    result.put(name, photos);
  }
  photos.add(photo);

}

System.out.println(result);