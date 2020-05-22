if (contInput.equals("1")) {
    System.out.println("Input the name of Container 1: ");
    String ContInp1 = reader.nextLine();
    Container container1 = new Container(ContInp1);
    container1.printContainer();
}