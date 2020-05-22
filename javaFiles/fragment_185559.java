for (dayOfMonth = 1; dayOfMonth <= orderedLengthOfMonthsArray[month]; dayOfMonth++) {
            if (dayOfMonth == 1 && dayOfWeek == 7) {
                System.out.println(dayOfMonth + " " + orderedNamesOfMonthsArray[month] + " " + year);
            }

            dayOfWeek++;

            if (dayOfWeek == 8) {
                dayOfWeek = 1;
            }                   
        }