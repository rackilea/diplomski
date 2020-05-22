try {
    //change path to phantomjs binary and your script file
    String outputFileName = "srulad";
    String phantomJSPath = "phantomjs" + File.separator + "bin" + File.separator + "phantomjs";
    String scriptFile = "simple.js";

    String urlParameter = "http://srulad.com/#page-2";

    new File(outputFileName+".html").delete();

    Process process = Runtime.getRuntime().exec(phantomJSPath + " " + scriptFile + " " + urlParameter + " " + outputFileName);
    process.waitFor();

    Document doc = Jsoup.parse(new File(outputFileName + ".html"),"UTF-8"); // output.html is created by phantom.js, same path as page.js
    Elements elements = doc.select("#list_page-2 > div");

    for (Element element : elements) {
        System.out.println(element.select("div.l-description.float-left > div:nth-child(1) > a").first().attr("title"));
        System.out.println(element.select("div.l-image.float-left > a > img.lazy").first().attr("data-original"));
    }
} catch (IOException | InterruptedException e) {
    e.printStackTrace();
}