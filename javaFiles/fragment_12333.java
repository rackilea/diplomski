//Declaration 

 private int[] tabDrawables = new int[] {
                    R.drawable.image1,R.drawable.image2,
                    R.drawable.image3, R.drawable.image4,
                    R.drawable.image5};



     private ArrayList<ImageView> listImages = new ArrayList<ImageView>();


    //When you find your images on the onCreate method
    //add all images here

    listImages.add(imageView1);
    listImages.add(imageView2);
        ...

    for (int i = 0; i < tabDrawables.length; i++) {
         listImages.get(i).setImageResource(tabDrawables[i]);
}