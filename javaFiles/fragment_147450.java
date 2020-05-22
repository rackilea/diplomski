InputStream is = new FileInputStream(xmlFileName);
InputStreamReader isr = new InputStreamReader(is, "UTF-8");
Document doc = new SAXBuilder().build(isr);

Element data = doc.getRootElement();
Element employee = data.getChild("employee");

XMLOutputter xmlOut = new XMLOutputter(Format.getPrettyFormat());
xmlOut.output(employee, System.out);