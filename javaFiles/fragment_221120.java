int month;
try {
    month = getMonth(date[0]);
} catch (InvalidMonthException e) {
    System.out.println(e.getMessage);
    return;
}
System.out.println(month); // Or whatever you want to do with your month.........