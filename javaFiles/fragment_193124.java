List reg = new ArrayList();
    //int add;
    reg.add(2);
    reg.add(5);
    reg.add(6);

    Random rand = new Random();
    int newReg = rand.nextInt(4) + 1;
    for (int i = 0; i < reg.size(); i++) {
        if (reg.get(i).equals(newReg)) {
            System.out.println("aa");
        }
    }