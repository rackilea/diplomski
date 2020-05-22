String string = "This is a string";
System.out.println(string);

String[] words = string.split(" ");
System.out.println(Arrays.toString(words));

String[][] wordsArray = new String[words.length][];
for (int i = 0; i < words.length; i++)
    wordsArray[i] = new String[] { words[i] };
System.out.println(Arrays.deepToString(wordsArray));