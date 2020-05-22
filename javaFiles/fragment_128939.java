if (name.length()>20) {
    String cutName = name.substring(0, 20);
    name = cutName;
}

System.out.print("Hello " +name+"!");