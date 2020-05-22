String j1;
if(s1==1){
    j1 = "KMPH";
    System.out.println("We will be using Kilometres for this calculation.");
}if(s1 ==2){
    j1 = "MPH";
    System.out.println("We will be using Miles for this calculation.");
}else{
    j1 = null;
    System.out.println("That is an invalid input, you must choose between 1 or 2.");
}