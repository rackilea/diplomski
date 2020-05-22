Document doc = Jsoup.connect("https:// (enter a url)").get();
        BufferedWriter  writer = null;
        try
        {
            writer = new BufferedWriter( new FileWriter("d://test.txt"));
            writer.write(doc.toString());

        }
        catch ( IOException e)
        {
        }