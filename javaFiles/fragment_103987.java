while(true){

    Scanner input = new Scanner(System.in);

    System.out.println("Enter text: "); 
    String s;
    s = input.nextLine();
    System.out.println("" + s);

    String[] strings = s.split(" ");
    int[] counts = new int[6];
    for(String str : strings)
        if(str.length() < counts.length) counts[str.length()] += 1;
    for(int i = 1; i < counts.length; i++)
        System.out.println(i + " letter words: " + counts[i]);

}