Scanner scanner = new Scanner(System.in);
System.out.println("Wie ist dein Geschlecht? M oder W?");
String geschlecht = scanner.nextLine();

System.out.println("Wie ist dein Alter?");
int alter = Integer.parseInt(scanner.nextLine());
if (alter >= 18 && alter <= 100) {
    System.out.println("Du bist volljaehrig, herzlichen Glueckwunsch!");
}