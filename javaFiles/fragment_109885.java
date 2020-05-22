class ifMain {
    public static void main(String[] args){
        String userName = "JDoe";              // <=== Declared here

        if (test.matches("JDoe")) {            // <=== Not used here
            System.out.println("You smell!");
        } else {
            UInput.saying();
        }
    }
}