char[] array = container.toCharArray();
int count = 0;
for (int i = 0; i < array.length; i++) {
    if (array[i] == ' ') {
        count++;
    }
}

// count counts the number of times a space appears
System.out.println(count);
int[] array2 = new int[count];
int counter = 0;
for (int i = 0; i < array.length; i++) {
    if (array[i] == ' ') {
        array2[counter] = i;
        counter++;
    }
}

// array2 assigns the indexes of spaces to its members
System.out.println(counter);

String[] array3 = new String[array2.length - 1];
for (int i = 0; i < array3.length; i++) {
    array3[i] = container.substring(array2[i], array2[i + 1]);
}
// array3 creates substrings based on these spaces
System.out.println(array3[1]);
System.out.println(array3[0]);