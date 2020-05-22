StringWriter expectedStringWriter = new StringWriter();
PrintWriter printWriter = new PrintWriter(expectedStringWriter);

printWriter.println("Quack");
printWriter.println("I'm flying!!");
printWriter.println("I can't fly");
printWriter.println("I'm flying with a rocket");
printWriter.close();

String expected = expectedStringWriter.toString();
assertEquals(expected, outContent.toString());