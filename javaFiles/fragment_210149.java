String testString = "TEST for stackoverflow";

byte[] bytes = testString.getBytes(StandardCharsets.UTF_8);
System.out.println("bytes = " + Arrays.toString(bytes));

bytes = testString.getBytes(StandardCharsets.ISO_8859_1);
System.out.println("bytes = " + Arrays.toString(bytes));