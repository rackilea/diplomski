int numSingle = 0;
for (i=0; i < RandomArray.length; i++) {
    int num = (int)(Math.random() * 100);
    if (num < 10) ++numSingle;
    RandomArray[i] = num;
    System.out.print(num + "  ");
}

System.out.println("There are " + numSingle + " integers in the array.");