Scanner s = null;
try {
    s= new Scanner(new File("translate.txt"));
} catch (FileNotFoundException e) {
    e.printStackTrace();  
}
while (s.hasNextLine()) {
        Scanner s2 = new Scanner(s.nextLine());
    boolean b;
    while (b = s2.hasNext()) {
        String s1 = s2.next();
        System.out.println(s1);
    }
}