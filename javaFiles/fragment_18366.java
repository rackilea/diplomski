String[] array = string.split("> ");

for (int i = 0; i < array.length -1; i++){
    System.out.println(array[i] + ">");
}
System.out.println(array[array.length-1]);