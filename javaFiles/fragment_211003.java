class pp {
        public static void main(String[] args) {
            Set<User> a = new HashSet<User>();

        User u = new User();
        u.setFirstName("Mike"); u.setLastName("Jordon");  
        a.add(u);

        u = new User();
        u.setFirstName("Jack"); u.setLastName("Nicolson");
        a.add(u);

        u = new User();
        u.setFirstName("Jack"); u.setLastName("Nicolson");

        a.add(u);

        for (User ss : a) {           
                System.out.println(ss.getFirstName() + " " + ss.getLastName());
        }
    }
}