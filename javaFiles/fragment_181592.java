boolean n2 ;   
if(num1>num2) {
    if(num1>num2 && num1>num3){
        if(num2>num3){
            System.out.println(num1+">"+num2+">"+num3);
            n2=true;
        }
        else {
            System.out.println(num1+">"+num3+">"+num2);
        }
    }
    else if(n2){
        if(num1<num3){
            System.out.println(num2+">"+num3+">"+num1);
        }
    }
}
else {
    System.out.println(num2+">"+num1+">"+num3);
}