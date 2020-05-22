// Convert the string to lowercase here, instead of within the loop
string lowerCaseText = text.toLowerCase();

for (String curse : cursewords) {
    if (lowerCaseText.contains(curse)) {
       System.out.println("found curse:" + curse);
    }
}