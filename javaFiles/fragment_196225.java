public static void addFlower(){
    Scanner input = new Scanner(System.in);
    ...
    int desiredThorns = Integer.parseInt(input.nextLine());
    ...
    flowerPack.add(new FlowerClass(desiredName, desiredColor, desiredThorns, desiredSmell));
}