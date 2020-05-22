System.out.print("[" + i + "]  ");
int starsToPrint = (int) Math.round((double) amountRoles[i] / 100.0);
for (int j = 0; j < starsToPrint; j++) {
    System.out.print("*");
}
System.out.println(" "  + amountRoles[i]);