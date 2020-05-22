static Set<String> taken = new HashSet <>();
    public static void main(String [] args)
    {
        Scanner scan = new Scanner (System.in);
        while (true) {
            System.out.println("enter id ");
            String id = scan.nextLine();
            if (taken.contains(id)) {
                System.out.println("already taken");
                continue;
            }
            taken.add (id);
            System.out.println("another [y/n]? ");
            if (scan.nextLine().equals("n"))
                break;
        }
    }