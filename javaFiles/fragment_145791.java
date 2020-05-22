final TextView text = (TextView)findViewById(R.id.text);

        String URL = "http://www.isleworthsyon.hounslow.sch.uk/";

        Document site = null;
        try {
            site = Jsoup.connect(URL).get();
        } catch (IOException e) {

            e.printStackTrace();
        }

        site.select("a").remove();

        Elements news = site.select("div#np_91983-1");

        Elements newsline = news.select("[align~=center]");

        String output = "";
        String  oldline = "";

        for (int i = 0; i < newsline.size(); i++) {


            String  newline = oldline + "\n" + newsline.get(i).text();  
            oldline = newline;
            output = newline;
          }           

        text.setText(output);