Scanner sc;
if (args.length > 0)
    sc = new Scanner (new FileInputStream(args[0]));
else
    sc = new Scanner (System.in);

// Now just use scanner as before