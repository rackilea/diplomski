str = "CATEGORYTYPE1\n" + 
"{\n" + 
"    CATEGORYSUBTYPE1\n" + 
"    {\n" + 
"        OPTION1 \"ABcd efg1234\"\n" + 
"        OPTION2 ABCdefg12345\n" + 
"        OPTION3 15\n" + 
"    }\n" + 
"    CATEGORYSUBTYPE2\n" + 
"    {\n" + 
"        OPTION1 \"Blah Blah 123\"\n" + 
"        OPTION2 Blah\n" + 
"        OPTION3 10\n" + 
"        OPTION4 \"Blah\"\n" + 
"    }\n" + 
"}\n";

String[] arr = str.split("(?s)(?=(([^\"]+\"){2})*[^\"]*$)\\s+");
System.out.println(Arrays.toString(arr));

// OUTPUT
[CATEGORYTYPE1, {, CATEGORYSUBTYPE1, {, OPTION1, "ABcd efg1234", OPTION2, ABCdefg12345, ...