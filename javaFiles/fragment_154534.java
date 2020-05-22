ArrayList<String> obj = new ArrayList<String>();

        obj.add("250");
        obj.add("300");
        obj.add("350");

        Collections.shuffle(obj);
        int rand1 = Integer.parseInt(obj.get(0));
        int rand2 = Integer.parseInt(obj.get(1));
        int rand3 = Integer.parseInt(obj.get(2));

        rb1.setBounds(400, rand1, 200, 15);
        rb2.setBounds(400, rand2, 200, 15);
        rb3.setBounds(400, rand3, 200, 15);