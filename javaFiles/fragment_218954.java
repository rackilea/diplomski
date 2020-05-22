try (Scanner sc = new Scanner(new File("patch"))) {
    while (sc.hasNextLine()) {
        String line = sc.nextLine();
        Scanner row = new Scanner(line);
        long sum = 0;
        int count = 0;
        while (row.hasNextInt()) {
            int val = row.nextInt();
            if (count == 0) {
                System.out.print(val);
            } else {
                System.out.printf(" + %d", val);
            }
            sum += val;
            count++;
        }
        System.out.println(" = " + sum);
    }
} catch (IOException e) {
    e.printStackTrace();
}