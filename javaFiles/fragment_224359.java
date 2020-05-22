Scanner x = null;
try {
    x = new Scanner(new File("C:\\Users\\فاطمة\\Downloads\\products.txt"));

    while(x.hasNext()) {
        String a = x.next(); // id
        String b = x.next(); // product name
        String c = x.next(); // product type
        String d = x.next(); // product brand
        int e = x.nextInt(); // product quantity
        int f = x.nextInt(); // production day
        int g = x.nextInt(); // production month
        int h = x.nextInt(); // production year
        int i = x.nextInt(); // expiry day
        int j = x.nextInt(); // expiry month
        int k = x.nextInt(); // expiry year
        String l = x.next(); // company name
        String m = x.next(); // supplier name
        String n = x.next(); // supplier address
        String p = x.next(); // supplier phone number
    }
} catch(Exception e) {
    System.out.println("No current products.");
}