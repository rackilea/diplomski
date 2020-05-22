for (int i = -200; i < 0; i++){
        if (dateposition == i){
            int month = currentMonthInt + i;
            int year = currentYearInt + (month / 12);

            if (month >= 0){
                month = (month % 12)+1;
            } else {
                int c1 = Math.abs(month / 12) + 1;
                month += (12 * c1);
            }

            String monthString = String.format("%02d", month);
            String yearString = String.valueOf(year);
            showListView(monthString, yearString, db);
        }
    }