// letter1 and letter2 would be created by some other method that you must define
String[] letter1 = new String[]{"MMMMMMMMMM", "MM  MM  MM", "MM  MM  MM", "MM  MM  MM", "MM  MM  MM", "MM      MM", "MM      MM"};
String[] letter2 = new String[]{"CCCCCCCCC" , "CCCCCCCCC", "CC       ", "CC       ", "CC       ", "CCCCCCCCC", "CCCCCCCCC"};

String[] concat = new String[letter1.length];
for (int i = 0 ; i < concat.length ; i++)
    concat[i] = letter1[i] + "\t" + letter2[i];

for (String s : concat)
    System.out.println(s);