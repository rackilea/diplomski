File file = new File("file.txt");

try {

    Scanner sc = new Scanner(file);

    while (sc.hasNextLine()) {
        int i = sc.nextInt();
        System.out.println(i);
    }
    sc.close();
} 
catch (FileNotFoundException e) {
    e.printStackTrace();
}
}