Style style = SLD.createPointStyle("square", Color.red, Color.red, 1.0f, 8.0f);
StyleBuilder styleBuilder = new StyleBuilder();
String attributeName = "name";
Font font = styleBuilder.createFont("Times New Roman", 10.0);
TextSymbolizer textSymb = styleBuilder.createTextSymbolizer(Color.black, font, attributeName);
Rule rule = styleBuilder.createRule(textSymb);
style.featureTypeStyles().get(0).rules().add(rule);