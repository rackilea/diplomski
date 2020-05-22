public static void main(String[] args) {
    String str = "Hello String with doubles 340046.0 2896.013478 3.0 ";
    Scanner s = new Scanner(str);
    while (s.hasNext()) {
        if (s.hasNextDouble()) {                
            System.out.format("The scanned double is : " + "%.3f \n", Double.parseDouble(s.next()));
        } else {
            System.out.println("We are left with " + s.next());
        }
    }
}