NodeList chapters = doc.getElementsByTagName("chapter");

         for(int i=0;i < chapters.getLength();i++) {
             Element chapter = (Element) chapters.item(i);
             System.out.println("Chapter = " + chapter.getAttribute("name"));
             Element verse = (Element) chapter.getElementsByTagName("verse").item(0);
             System.out.println(verse.getAttribute("text"));
         }