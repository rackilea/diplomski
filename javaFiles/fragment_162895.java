LocalDate currentDate = LocalDate.now();
int year = currentDate.getYear();
int month = currentDate.getMonthValue();

for (int i = year - 2; i <= year; i++) {
    for (int j = 1; j <= 12; j++) {
        if (i == year && j == month) {
            System.out.print(i + " " + j + " ");
            break;
        }
            System.out.print(i + " " + j + " ");
        }
    }
}