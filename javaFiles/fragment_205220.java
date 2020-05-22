String[] products = "Pizza-1*Nutella-20*Chicken-65*".split("\\*");

for (String product : products) {
    String[] prodNameCount = product.split("\\-");
    System.out.println(prodNameCount[0] + " " + prodNameCount[1]);
}