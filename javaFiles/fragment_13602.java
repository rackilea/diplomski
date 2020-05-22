public static void main(String[] args){
    Object[] array = Math.random()<.5? new String[2]: new Object[2];
    array[0] = "Hello, World!";//compiler knows this is safe
    System.out.println(array[0]);
    array[1] = new Object();//compiler must check array type
}