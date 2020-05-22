int count = 0;
while((outputline = fin.readLine()) != null) { 
    if (count > 0)
        System.out.print(", ");

    System.out.print(outputline); 
    count++;
}
System.out.println();