double itemCost = 0;
if (strs){
    System.out.print("Enter qty of " + str[0] + " (by bag): ");
    itemCost = price[0]; 
}

if (strs1) {
    System.out.print("Enter qty of " + str[1] + " (by bag): ");
    itemCost = price[1]; 
}
if (strs2) {
    System.out.print("Enter qty of " + str[2] + " (by bag): ");
    itemCost = price[2]; 
}

int qty = sc.nextInt();
int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
int h = 1;
int[] g = {0,1,2};

if ((a[h] == (qty))  || (strs) || (strs1) || (strs2)) {
    System.out.print("\n"+ qty + " bag(s) of " + string1 + " have been added to your basket, " 
    + "total costing £"+ (qty) * (itemCost) + "p");