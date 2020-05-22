if (year % 4 == 0 && "Feb".equals(month)){
    // Note the && above
    System.out.println( month + year + "has 29 days");
}
else if (year % 4 > 0 && "Feb".equals(month)){
    // Note the && above
    System.out.println( month + year + "has 28 days");
}