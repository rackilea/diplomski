public static void main(String[] args) {

// if no command line arguments, list directory
if (args.length==0){
File f = new File(".");
File[] files = f.listFiles();
DateFormat df = new SimpleDateFormat("MMM dd HH:mm:ss");

    // for each File in array, print out
    for (int i =0; i<files.length; i++){
        System.out.printf("%8d %s %s%n", files[i].length(), df.format(files[i].lastModified()), files[i].getName());
        System.exit(0);
    }

//NOT WORKING
if(args.length==1){


File f = new File(args[0]);
if (!f.isDirectory())
    System.exit(1);
File[] files = f.listFiles();
DateFormat df = new SimpleDateFormat("MMM dd HH:mm:ss");

    // for each File in array, print out
    for (int i =0; i<files.length; i++){
        System.out.printf("%8d %s %s%n", files[i].length(), df.format(files[i].lastModified()), files[i].getName());
        System.exit(0);
    }

}

}