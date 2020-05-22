public int readFile() {
    String score = null;
    while (scan.hasNext()) {
        String a = scan.next();
        String b = scan.next();
        String c = scan.next();
        String d = scan.next();
        String e = scan.next();
        String f = scan.next();
        String g = scan.next();
        String h = scan.next();
        String i = scan.next();

        String nextVal = scan.next();

        if (c.equals(nextVal) && d.equals(nextVal) && e.equals(nextVal)) {
        } else {
            temp = Integer.parseInt(i);
            if (temp > highscore) {
                highscore = temp;
            }
        }

    }
    return highscore;
}