Tree t = index.addChild("oak:index");

t = t.addChild("lucene");
t.setProperty("jcr:primaryType", "oak:QueryIndexDefinition", Type.NAME);
t.setProperty("compatVersion", Long.valueOf(2L), Type.LONG);
t.setProperty("type", "lucene", Type.STRING);
t.setProperty("async", "async", Type.STRING);

t = t.addChild("indexRules");
t = t.addChild("nt:base");
Tree propnode = t.addChild("properties");
Tree t1 = propnode.addChild("name");
t1.setProperty("name", "name");
t1.setProperty("propertyIndex", Boolean.valueOf(true), Type.BOOLEAN);
root.commit();