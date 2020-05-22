for(int i=0; i<=9999; i++){
    if(i<10){
        System.out.println("000"+i);
    }
    else if(i<100){
        System.out.println("00"+i);
    }
    else if(i<1000){
        System.out.println("0"+i);
    }
    else{
        System.out.println(i);
    }
}