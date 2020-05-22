for (int i = 1900; i <= N; i++) {
        for (int month = 1; month <= 12; month++) {
            if ((i == 1900) && (month == 1)) {
                counter[position - 1]++;
                position = 31%7 + 1;
            }