public class Class2 {
    int software;

    public Class2(String s) {
        Company(s);
        System.out.println(s);
        System.out.println(software);
    }

    public void Company(String s) {
        if(s.equals("Microsoft")||s.equals("Norton")||s.equals("Oracle")||s.equals("CRM")){
            if(s.equals("Microsoft")) {
                software = 1200000;
                System.out.println("Matches Microsoft");
            } else if(s.equals("Norton")) {
                software = 3000000;
                System.out.println("Matches Norton");
            } else if(s.equals("Oracle")) {
                software = 1700000;
                System.out.println("Matches Oracle");
            } else if(s.equals("CRM")) {
                software = 2300000;
                System.out.println("Matches CRM");
            }
        } else {
            System.out.println("Not a company, GOOD BYE!");
        }
    }
}