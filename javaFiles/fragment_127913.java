String months[] = {"January", "February", "March", "April",
        "May", "June", "July", "August", "September",
        "October", "November", "December"};

int monthIndex = LocalDate.now().getMonth().ordinal();//indexed from 0

Collections.rotate(Arrays.asList(months), -monthIndex); //negative value rotates to left

System.out.println(Arrays.toString(months));