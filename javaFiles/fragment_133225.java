try {
    System.out.print("Entry " +i + "/5, enter an integer value: ");
    NumberEntry[i] = scan.nextInt();
}
catch (Exception e){
    scan.next();
    i--;
    continue;
}