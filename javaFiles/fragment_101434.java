try {
        doc = Jsoup.connect(params[0]).get();
        Element tableElement = doc.select(".datagrid").first();

        Elements tableRows = tableElement.select("tr");
        for (Element row : tableRows) {
            Elements cells = row.select("td");
            if (cells.size() >0) {
                System.out.println(cells.get(0).text()+"; "+cells.get(1).text()+"; "+cells.get(2).text()+"; "+cells.get(3).text());
            }
        }


    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }