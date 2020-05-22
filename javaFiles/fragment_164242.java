// Since the lib depends on Guava, might as well use that
final List<String> months = ImmutableList.of("jan", "feb", "etc");

// Create the template
final URITemplate template 
    = new URITemplate("http://www.asite.com/path/to/something/{int1}/{month}-{int2}");

// Variable values
VariableValue int1, month, int2;

// Expansion data
Map<String, VariableValue> data;

// Build the strings
for (int i1 = 0; i1 <= 10; i1++)
    for (final String s: months)
        for (int i2 = 0; i2 <= 1000; i2++) {
            int1 = new ScalarValue(Integer.toString(i1));
            month = new ScalarValue(s);
            int2 = new ScalarValue(Integer.toString(i2));
            data = ImmutableMap.of("int1", int1, "month", month, "int2", int2);
            // Print the template
            System.out.println(template.expand(data));
        }