URL url = new URL("http://localhost:8080/job/test_job/api/xml");
// read information into DOM.
Document dom = new SAXReader().read(url);
// scan through build list of test_job job and print its info
for (Element build : (List<Element>) dom.getRootElement().elements("build")) {
    System.out.println(String.format("Number:%s\tUrl:%s", build.elementText("number"), build.elementText("url")));
}