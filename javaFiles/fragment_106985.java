final URITemplate tmpl = new URITemplate("http://my.site/some/where?word={word}");
final VariableMapBuilder builder = VariableMap.newBuilder();
builder.addScalarValue("word", "Conformément");
tmpl.toString(builder.freeze()); // returns the correct result
// Or:
tmpl.toURI(builder.freeze());
tmpl.toURL(builder.freeze());