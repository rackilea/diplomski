String sentence = "This is a basic sentence sequence using letters and spaces in unicode!";
int i = 0;
int index = sentence.offsetByCodePoints(0, i);
int cp = sentence.codePointAt(i);
System.out.println(index);
if (Character.isSupplementaryCodePoint(cp)) i += 2;
else i++;
System.out.println(i);