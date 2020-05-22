public static void main(String[] args) {

    Scanner Stof = new Scanner(System.in);

    String[] MainArr = new String[3];

    MainArr[0] = "Goud";
    MainArr[1]= "Zilver";
    MainArr[2]="Tin";

    int x = 1;
    while(true) {
        System.out.println("Kies een stof waar je meer info over wil: goud, zilver of tin");
        System.out.println("type hem hieronder in en druk dan op enter!");

        String gekozenStof = Stof.next();

        if(gekozenStof.equalsIgnoreCase(MainArr[0])){
            System.out.println("Het is een metaal");
            System.out.println("Atoomnummer is 79");
            System.out.println("EN-waarde is 2,54");
        }else if(gekozenStof.equalsIgnoreCase(MainArr[1])){
            System.out.println("Het is een metaal");
            System.out.println("Atoomnummer is 47");
            System.out.println("EN-waarde is 1,93");
        }else if(gekozenStof.equalsIgnoreCase(MainArr[2])){
            System.out.println("Het is een metaal");
            System.out.println("Atoomnummer is 50");
            System.out.println("EN-waarde is 1,96");
        }
        System.out.println("Doorgaan? J/N");
        if (Stof.next().equalsIgnoreCase("N")) {
            break;
        }
    }
}