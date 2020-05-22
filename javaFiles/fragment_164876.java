for (Element e : document.body().select("div table")) {
    Elements trs = e.select("tr");
    if ("FAIL".equalsIgnoreCase(trs.last().select("td").last().text())) {
        String id = trs.first().select("td").last().text();
        System.out.println(id);
    }
}