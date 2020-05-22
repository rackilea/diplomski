phrase = phrase.substring(lastSpaceIndex + 1);
int firstIndex = phrase.indexOf(' ', 0);
int secondIndex = phrase.indexOf(' ', firstIndex + 1);
int thirdIndex = phrase.indexOf(' ', secondIndex + 1);
phrase = phrase.substring(0, phrase.indexOf(' ', thirdIndex));
System.out.println(phrase);