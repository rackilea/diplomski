int age = 0;
if (dataParts[1].matches("\\d+")) {
    age = Integer.parseInt(dataParts[1]);
    // OR  age = Integer.valueOf(dataParts[1]);
    System.out.println("Age = " + age);  
}
else {
    System.out.println("Age is not a numerical value!");  
}