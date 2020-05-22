String stringToFind = "If you have any questions on how to use jsoup";
try {
    Document doc = Jsoup.connect("https://jsoup.org/").get();
    if (doc.text().contains(stringToFind)) {
        System.out.println("Yes...String exists in web-page.");
    }
    else {
        System.out.println("No...String does not exist in web-page.");
    }
}
catch (IOException ex) {
    // Do whatever you like to handle the exception...
}