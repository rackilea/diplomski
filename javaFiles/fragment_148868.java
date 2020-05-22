Scanner fi = new Scanner("string 200 200.0");
fi.useLocale(Locale.US);

while (fi.hasNext()) {
    if (fi.hasNextInt()) {
        System.out.println("Integer: " + fi.nextInt());
    } else if (fi.hasNextDouble()) {
        System.out.println("Double: " + fi.nextDouble());
    } else {
        System.out.println("String: " + fi.next());
    }  
}