ResultSet rs = session.execute("select json * from test.jtest ;");
    int i = 0;
    System.out.print("[");
    for (Row row : rs) {
        if (i > 0)
            System.out.print(",");
        i++;
        String json = row.getString(0);
        System.out.print(json);
    }
    System.out.println("]");