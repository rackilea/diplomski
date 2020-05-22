Random rn = new Random();
ArrayList<Image> imageSet = importImages();
ArrayList<Image> randomizedSet = randomize(imageSet, rn);

public static ArrayList<Image> importImages() {
    ArrayList<Image> images = new ArrayList<>();
    // put some code here to add each image to images twice
    return images;
}

public static ArrayList<Image> randomize(ArrayList<Image> imageSet, Random rn) {
    ArrayList<Image> images = new ArrayList<>();
    while (!imageSet.isEmpty()) {
        images.add(imageSet.remove(rn.nextInt(imageSet.size())));
    }
    return images;
}