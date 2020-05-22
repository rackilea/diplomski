//remove everything not in the alphabet
str = str.replaceAll("[^a-zA-Z ]" , " ");
//remove all multiple spaces and replace with a single space
str = str.replaceAll("\\s+", " ").trim();

String words[] = str.split(" ");