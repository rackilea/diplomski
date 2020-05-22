int year = 0;
String place = "";
Scanner place_in = new Scanner(System.in);
System.out.print("Enter place of Birth : ");
place = place_in.nextLine();
String bday = "";
Scanner bday_in = new Scanner(System.in);
System.out.print("Enter Birthday (Month Day,Year): ");
bday = bday_in.nextLine();

for(int i=0;i<bday.length();i++) {
    if(bday.charAt(i)==','){
      year = Integer.parseInt(Character.toString(bday.charAt(i+2))+Character.toString(bday.charAt(i+3))+Character.toString(bday.charAt(i+4))+Character.toString(bday.charAt(i+5)));
    }
}