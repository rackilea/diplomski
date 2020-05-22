public static void main(String[] args) {
    ShoeStoreOrder sso;
    System.out.println("No discount");
    sso = new ShoeStoreOrder("vertical", "winter", 20, 5, 10, 1);
    System.out.println(sso.gettotalamount());

    System.out.println("After discount");
    sso = new ShoeStoreOrder("vertical", "winter", 20, 5, 10, 5);
    System.out.println(sso.gettotalamount());

    sso = new ShoeStoreOrder("vertical", "winter", 20, 5, 10, 50);
    System.out.println(sso.gettotalamount());
}