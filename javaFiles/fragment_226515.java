EndTimeComparator endTime = new EndTimeComparator();
Collections.sort(col, endTime);

DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
LocalDate findThis = LocalDate.parse("2015-03-10", dtf);

System.out.println("Here is 'endTime= 2015-03-10' :");
for (Monitoring x : col) {
    if (x.getEndTime().toLocalDate().equals(findThis)) {

        System.out.println(x.toString());

    }
}