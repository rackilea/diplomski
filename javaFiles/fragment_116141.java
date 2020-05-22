XStream s = new XStream(new DomDriver());
s.processAnnotations(ParentResponseObject.class);
ParentResponseObject gh = (ParentResponseObject) s.fromXML(xml);

for (ResponseObject o : gh.responseObjects) {
     System.out.println(o.Type);
     for (Properties p : o.properties) {
         System.out.println(p.Name + ":" + p.Type + ":" + p.Value);
     }
}