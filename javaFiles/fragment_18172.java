public static void main(String[] args) {
    if (args.length == 1)   {
    //do a thing
    } else if (args.length == 2){
        if(args[1].toUpperCase().equals("string i'm looking for"))
            //do a thing
    } else if (args.length == 3) {
        if(args[1].equals("string1")&& args[2].equals("string2")    || args[2].equals("string1")&& args[1].equals("string2"))
            //do a thing
        }
    }