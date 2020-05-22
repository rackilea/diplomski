//You can make ImageViewModel type class there you save your image view
     class ImageViewModel {

        public ImageView getImage() {
            return image;
        }

        public void setImage(ImageView image) {
            this.image = image;
        }

        ImageView image;

    }
    ArrayList<ImageViewModel> images = new ArrayList<>();
    ArrayList<Integer> drawables = new ArrayList<>();
    drawables.add(R.mipmap.ic_launcher);
    drawables.add(R.mipmap.ic_launcher);
    drawables.add(R.mipmap.ic_launcher);



    //set you imageview in model class and add into the arraylist of modelclass type
    ImageViewModel model = new ImageViewModel();
    model.setImage(imageviews);
    images.add(model);




   // Then you can set this as
    for(int i = 0; i<drawables.size(); i++){

         model.getImage().setImageResource(drawables.get(i));
    }