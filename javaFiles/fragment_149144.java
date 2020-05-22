@Override
  public int getItemViewType(int position) {

//Gallery.Photo and Gallery.Vedio are the models
    if (objects.get(position) instanceof Gallery.Photo) {
      return VIEW_TYPE_PHOTO;
    } else if (objects.get(position) instanceof Gallery.Vedio) {
      return VIEW_TYPE_VIDEO;
    } else {
      return VIEW_TYPE_ESSAY;
    }
  }