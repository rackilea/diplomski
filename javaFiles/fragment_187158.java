public static String getRandomPage() {

    List<String> pages = getAllPagesInDatabase();
    if(pages == null || pages.size() == 0)
        return null;

    //get random page from the list
    Random random = new Random();
    int randomNumber = random.nextInt(pages.size());

    return pages.get(randomNumber);
}