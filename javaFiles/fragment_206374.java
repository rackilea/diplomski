if (Content.contains("SKU:")) {

    int index = Content.indexOf("SKU:");
    String SKU = Content.substring(index, index + 15);
    System.out.println("Product SKU is : " + "" + SKU);

}