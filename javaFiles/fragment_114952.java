public static void main(String[] args)
{
    if (args.length != 2) {
        System.out.println("You did not enter two words!");
    }

    sameChars(args[0], args[1]);        
    printWords(args[0], args[1]);             
}