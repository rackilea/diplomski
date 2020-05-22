public void searchBird(int indexPosition) {
    // there might be the following case: indexPosition > maximum index of birdList
    if (indexPosition < birdList.size()) {
        Bird bird = birdList.get(indexPosition);
        System.out.println("Art:" + bird.getArt());
        System.out.println("Location:" + bird.getLocation());
    } else {
        System.out.println("The given index exceeds the list of birds!");
    }
}