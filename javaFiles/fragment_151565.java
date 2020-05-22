new Document(
     new Element ("adressbuch")
     .setAttribute("aktualisiert", "1.4.2008")
     .addContent(
         (Element) new Element("adresse")
         .addContent(
                     (Element) new Element("vorname")
                     .addContent("Hugo"))
         .addContent(
                     (Element) new Element("nachname")
                     .addContent("Meier"))
         .addContent(
                     (Element) new Element("telefon")
                     .setAttribute("typ", "mobil")
                     .addContent("0160/987654"))));