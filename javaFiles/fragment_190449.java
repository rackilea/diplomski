File f = new File ("C:/Users/seanbright/Desktop/Test File.htm");

Document doc = Jsoup.parse(f, "UTF-8");
doc.outputSettings()
    .syntax(Document.OutputSettings.Syntax.xml)
    .escapeMode(Entities.EscapeMode.xhtml);

System.out.println(doc.toString());