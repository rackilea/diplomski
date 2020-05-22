public static void main(String[] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader(
            "/home/shaleen/USACO/friday/friday.in"));
    // input file name goes above

    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
            "/home/shaleen/USACO/friday/friday.out")));
    // Use StringTokenizer vs. readLine/split -- lots faster
    // StringTokenizer st = new StringTokenizer(f.readLine());
    // Get line, break into tokens.

    int n1 = Integer.parseInt(f.readLine());
    int[] counter = new int[7];

    int N = 1900 + n1 - 1;
    int position = 1; // first 13th is a Saturday

    for (int i = 1900; i <= N; i++) {
        for (int month = 1; month <= 12; month++) {
            if ((i == 1900) && (month == 1)) {
                counter[position - 1]++;
                position = 31%7 + 1;
            }
            else if ((i == N) && (month == 11)) {
                position += 2;
                position %= 7;
                counter[position - 1]++;
                System.out.println(i + " " + month + " " + position + " ");
                break;
            } else if ((month == 4) || (month == 6) || (month == 9)
                    || (month == 11))
                position += 2;
            else if (month == 2) {
                if ((i % 400 == 0) || ((i % 100 != 0) && (i % 4 == 0)))
                    position += 1;
                else
                    position += 0;
            } else
                position += 3;

            if (position > 7)
                position %= 7;

            counter[position - 1]++;

            System.out.println(i + " " + month + " " + position + " ");
        }

    }

    for (int x : counter) {
        System.out.print(x + " ");

    }
}
}