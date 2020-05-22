Double number = null;

do{
try{


System.out.println("Enter number");
number = Double.parseDouble(br.readLine());

}catch(Exception ex){
    System.out.println(ex +"\nEnter an int or double value");
}
}while(number==null);