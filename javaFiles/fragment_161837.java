Scanner scan = new Scanner(System.in);

    FileWriter f;
    BufferedWriter b;
    try {
        f = new FileWriter("file.txt");
        b = new BufferedWriter(f);

        String str1 = scan.nextLine();
        String str2 = scan.nextLine();
        String str3 = scan.nextLine();

        b.write(str1 + "," + str2 + "," + str3);


        b.close();
        f.close();
    } catch (IOException e) {
        e.printStackTrace();
    }