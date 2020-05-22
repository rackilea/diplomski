public List<String> perform(String url, String searchWord) {
    // webdriver that opens the given URL
    driver.get(url); 
    searchWord = searchWord.toLowerCase();

    // get the top most element on page, it will be html in most cases
    WebElement html = driver.findElement(By.cssSelector("html"));

    // gets all the text on page
    String htmlText = html.getText().replaceAll("\n", " ").toLowerCase();

    // split by space to get all words on page
    String[] allWords = htmlText.split(" ");

    List<String> myWordList = new ArrayList<String>();

    // add all the words that contains your search word
    for (String word : allWords)
        if (word.contains(searchWord))
            myWordList.add(word);

    return myWordList;
}