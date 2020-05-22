static void test1() throws Exception {

    String sat[] = new String[10];
    //server
    String[] sa = {"okay", "okay", "okay", "okay", "okay", "okay", "okay"
        , "okay", "okay", "okay", "okay", "okay", "okay", "okay", "okay", "okay"};

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(baos);
    oos.writeObject(sa);
    System.out.println(sat.length);//->10
    //client
    ObjectInputStream is = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
    sat = (String[]) is.readObject();//->sat points to another array now
    System.out.println(sat.length);//->16

  }