public int getyear( LocalDate date) {
        System.out.println(date.getYear());
        if(date.getMonthValue() < 4){
            return date.getYear() - 1;
        }
        return date.getYear();

    }