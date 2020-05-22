public static ArrayList<String> getResponse(String url) throws IOException {
    return getResponse(ulr, 3);
} 

private static ArrayList<String> getResponse(String url, int retryCount) throws IOException {
    ArrayList<String> resultList = new ArrayList<>();
    if (retryCount <= 0){
        //fail gracefully
        resultList.add(0, "");
        return resultList;
    }
    retryCount--;
    try {
        Document doc = Jsoup.connect(url).timeout(10000).get();
        Elements links = doc.select("a");
        int j = 0;

        for (int i = 0; i < links.size(); i++) {
            if (links.get(i).attr("abs:href").contains("http")) {
                resultList.add(j, links.get(i).attr("abs:href"));
                j++;
            }
        }
        return resultList;
    } catch (HttpStatusException e) {

        resultList.add(0, "");
        return resultList;
    } catch (SocketTimeoutException e) {

        getResponse(url, retryCount);
    }
    return resultList;
}