String[] random = new String[3];
random[0] = "b";
random[1] = "c";
random[2] = "a";
int x = 0;
//"random" is array with stored integers
for (int i = 0; i < random.length; i++) { 
    // Assume first value is x
    x = i;
    for (int j = i + 1; j < random.length; j++) {
        //find smallest value in array (random)
        if (random[j].compareTo(random[x]) < 0) {
            x = j;
        }
    }
    if (x != i) {
        //swap the values if not in correct order
        final String temp = random[i];
        random[i] = random[x];
        random[x] = temp;
    }
    System.out.println(random[i] + "\n");// Output ascending order
}