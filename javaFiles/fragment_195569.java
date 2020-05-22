private static final int LOOPS = 3;

public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    List<Phone> phones = new ArrayList<>();
    for(int i = 0; i < LOOPS; i++){
        System.out.println("What brand?");
        String inputBrand = scan.nextLine();
        switch(inputBrand) {
            case "LG" : phones.add(new LG());
                break;
            case "Samsung" : phones.add(new Samsung());
                break;
            case "Huawei" :  phones.add(new Huawei());
                break;
            default : System.out.println("Your code is less than optimal");
                break;
        }
    }
    for(Phone p : phones){
        System.out.println(p.toString());
    }
    scan.close();
}