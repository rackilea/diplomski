Scanner s = new Scanner(System.in);
System.out.println("Give your sentence: ");
String sentence = s.nextLine();
String nospace = sentence.replace(" ", "");
String out = addSpacesEvery5(nospace);
System.out.println("Sentence without spaces: " + nospace);
System.out.println("This gives: " + out);