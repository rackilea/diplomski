// store the length of the month and the first day of month's weekday number
int lengthOfMonth = LocalDate.now().lengthOfMonth();
int firstDayOfMonthsWeekDay = LocalDate.now().withDayOfMonth(1).getDayOfWeek().getValue();

// use a labeled break statement to terminate the outer for loop when we reach the end of the month
month:
for (int i = 0; i < 6; i++) {
    for (int j = 0; j < 7; j++) {
        if(--firstDayOfMonthsWeekDay > 0){ // fixing first day of month's weekday to start counting from tuesday for example
            continue;
        }

        mycalendar[i][j] = firstday++;
        if (firstday > lengthOfMonth) {
            break month;                   // the execution will continue after the outer loop
        }
    }
}

for (int i = 0; i < 6; i++) {
    for (int j = 0; j < 7; j++) {
        System.out.print((mycalendar[i][j] == 0 ? " " : mycalendar[i][j]) + "\t");  // replace 0's in the array with spaces
        if (j == 6) {
            System.out.println();
        }
    }
}