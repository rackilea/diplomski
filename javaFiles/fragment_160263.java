String var = in.next();

switch(var) {
    case "1":
        System.out.println("Enter num");
        long num = in.nextLong();                  
        a.getPrime(num);
        break;

    case "q":
        System.out.println("Thanks for using");
        System.exit(0);
        break;

    default:
}