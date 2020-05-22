Document doc = Document.createShell("");

Element headline = doc.body().appendElement("h1").text("thats a headline");
Element pTag = doc.body().appendElement("p").text("some text ...");
Element span = pTag.prependElement("span").text("That's");

System.out.println(doc);