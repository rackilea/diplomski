int count = 0;
int month = cal.get(Calendar.MONTH);
while (cal.get(Calendar.MONTH) == month) {
    count++;
    cal.add(Calendar.DATE, 7);
}

System.out.println("This month has " + count + " saturdays");