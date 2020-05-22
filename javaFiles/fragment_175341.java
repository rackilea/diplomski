// Immutable, can be reused as many times as you wish
final URITemplate template = new URITemplate("https://graph.facebook.com/{userId}"
    + "/notifications?template={template}"
    + "&href=processThis.jsp?param={value}"
    + "&access_token=abc123");

final Map<String, VariableValue> vars = new HashMap<String, VariableValue>();

vars.put("userId", new ScalarValue("Ankur"));
vars.put("template", new ScalarValue("HelloAnkur"));
vars.put("value", new ScalarValue("ParamValue");

// Build the expanded string
final String expanded = template.expand(vars);

// Go with the string