PebbleEngine engine =
        new PebbleEngine.Builder().strictVariables(true)
                .extension(new InstanceofExtension()).build();

PebbleTemplate compiledTemplate = engine.getTemplate("home.html");

// Test with Person as v
Writer personWriter = new StringWriter();

Map<String, Object> context = new HashMap<>();
context.put("v", new Person());
compiledTemplate.evaluate(personWriter, context);

System.out.println(personWriter.toString()); // <b>asdasdasdasds</b> is present

// Test with Fruit as v
Writer fruitWriter = new StringWriter();

context.put("v", new Fruit());
compiledTemplate.evaluate(fruitWriter, context);

System.out.println(fruitWriter.toString()); // <b>asdasdasdasds</b> is not present, but
                                            // <b>red</b> is