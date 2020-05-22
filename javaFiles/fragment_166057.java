public static void main(String[] args) {
        Date currentDate = new Date();
        System.out.println(currentDate);
        long milliseconds = (long) 365 * 24 * 60 * 60 * 1000;
        Date oneYearBefore = new Date(currentDate.getTime() - milliseconds);
        System.out.println(oneYearBefore);
    }

Mon Nov 17 13:11:10 IST 2014
Sun Nov 17 13:11:10 IST 2013