for (LocalDate date : localDatesList) {
        final DateTimeFormatter formatter = DateTimeFormat.forPattern("MMMM dd,YYYY");          
        String str = formatter.print(date);
        System.out.println(str);
        tempDatesList.add(str);
    }