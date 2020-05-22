try {
    doc=  Jsoup.connect("http://www.delhisldc.org/DynamicData.aspx").get(); 

    Element element=doc.getElementById("LblLoad");
    Element element1=doc.getElementById("LblFrequency");
    Element element2=doc.getElementById("LblMaxToday");

    delhiload = element.text();
    delhifreq = element1.text();
    delhimaxload = element2.text();

    parseddata="Delhi Load:"+delhiload+System.getProperty ("line.separator")+"Frequency:"+delhifreq+System.getProperty ("line.separator")+"Max Load:"+delhimaxload;

} catch (IOException e) {
    e.printStackTrace();
}