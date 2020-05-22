public void start() {
    MyImage[] images = /* a list of your images */
    ImageView[] imageViews = /* a list of your imageViews (in this case, 4)*/
    fillImageViews(/* the desc */, imageViews, images);
}




private class MyImage() {
    Drawable image;
    String desc;

    public MyImage(Drawable img, String description) {
        image = img;
        desc = description;

    }

}

public void fillImageViews(String desc, ImageView[] views, MyImage[] images) {
    ArrayList<Integer> usedIndexs = new ArrayList();
    Random rand = new Random();
    for (ImageView v : views) { 
        while (usedIndexs.size() < images.length) {
            int index = rand.nextInt(images.length);
            if (images[index].desc.equals(desc) && !usedIndexs.contains(index)) {
                //description matches
                v.setImageDrawable(images[index].image);
                usedIndexs.add(index);
                break;
            }
            usedIndexs.add(index);
        }
    }
}