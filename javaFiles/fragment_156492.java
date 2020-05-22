fsc = new Scanner(new File(fileName));
fsc.useDelimiter("[ ,\r\n]");
while (fsc.hasNextLine()) {
    while (fsc.hasNextInt()){
        System.out.print(fsc.nextInt() + ","); 
    }
    System.out.println();
    if (fsc.hasNextLine())
        fsc.nextLine(); 
}