String books[] = {"This", "That", "The Other Longer One", "Fourth One"};
double booksPrices[] = {45.99, 89.34, 12.23, 1000.3};
System.out.printf("%-20s%-30s%s%n", "Inventory Number", "Books", "Prices");
for (int i=0;i<books.length;i++){
    System.out.format("%-20d%-30s$%.2f%n", i, books[i], booksPrices[i]);
}