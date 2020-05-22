Scanner sc = new Scanner(System.in);
String myString = sc.nextLine();
String[] flostr = myString.split(" ");
DecimalFormat df = new DecimalFormat("#.##");

for(String s : flostr){
   System.out.println(Float.parseFloat(s) +" ," + df.format(Math.sqrt(Float.parseFloat(s))));
}