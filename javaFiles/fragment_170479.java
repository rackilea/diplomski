public static void someMethod(String... arguments){
    // implementation is irrelevant but will add it for demo purpose
    System.out.println("I have "+arguments.length +"arguments which are:");
    for (String arg:arguments)
        System.out.println(arg);
}