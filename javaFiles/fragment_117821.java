ArrayList<Drawable> catPics = new ArrayList();
//add cat pics here
ArrayList<Drawable> dogPics = new ArrayList();
//add dogs pics here

//And now you could make function to pull the pictures
public Drawable getRandomPicture(ArrayList<Drawable> imgs) {
    return imgs.get(new Random.nextInt(imgs.size()));
}