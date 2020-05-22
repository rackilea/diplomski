try {
    //Connect to the url, and set the user agent so we don't get blocked out
    Connection connect = Jsoup.connect("http://www.hearthpwn.com/cards/503-ragnaros-the-firelord");
    connect.userAgent("Mozilla/5.0");

    //Get the html and select the first <video class="hscard-video" ...
    Document doc = connect.get();
    Element video = doc.select("video.hscard-video").first();

    //Grab all the data from it as a map (ex. data-href, data-usegold...)
    Map<String, String> dataSet = video.dataset();

    //If data-animationurl exists, print it (here you can store it as a String instead 
    if(dataSet.containsKey("animationurl")){
        System.out.println(dataSet.get("animationurl"));
    }
} catch (IOException e) {
    e.printStackTrace();
}