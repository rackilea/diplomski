public static void main(String... args){

    try {
        System.out.println ("This will run always");

 // this will not work because returnUser() is not a static method and there is no "this" in "static void main()"
        User user = this.returnUser();

        System.out.println ("this should only run if a user was returned");
        return "Success";

    } catch (UserNotFoundException e) {
        System.out.pring("otherwise 'USER_NOT_FOUND' should be returned and end app.");
    }