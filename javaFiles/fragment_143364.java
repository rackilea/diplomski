if( answer.equals("E"))
{
    Scanner scan2 = new Scanner(System.in);
    System.out.print("Enter a word or phrase in English: ");
    String englishInput = scan.next();
    System.out.println(toMorse(englishInput));
    scan2.close();
}