if(file.exists())
{   //If the file exists, print out each element on the file.
    Scanner input = new Scanner(file);
    int count = 0;
    while(input.hasNextInt())
    {
        randomArray[count++] = input.nextInt();
    }
    input.close();
    Arrays.sort(randomArray);

    for(int i = 0; i < size; i++) {
        System.out.println(randomArray[i]);
    }
}