while(scanner.hasNext()) {
    line = scanner.next();
    if (next.equals(word)) {
        if (count > 1) {
            System.out.println(x);
            System.out.println(y);
            System.out.println(z);
        }

        System.out.println("zone=:"+count);
        count++;
        x = new ArrayList<Double>();
        y = new ArrayList<Double>();
        z = new ArrayList<Double>();
    } else {
        String[] d = line.split(' ');
        x.add(Double.parseDouble(d[0]);
        y.add(Double.parseDouble(d[1]);
        z.add(Double.parseDouble(d[2]);
    }
}

if (count > 1) {
    System.out.println(x);
    System.out.println(y);
    System.out.println(z);
}