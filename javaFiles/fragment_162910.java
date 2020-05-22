NodeList<Element> scripts = Document.get().getElementsByTagName("script");
    for (int i = 0; i < scripts.getLength(); i++) {
      Element e = scripts.getItem(i);
      if (e.getAttribute("src").matches(".*myjslib.js")) {
        return;
      }
    }
    ScriptInjector.fromUrl("myjslib.js").inject();