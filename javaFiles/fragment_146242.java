for(int i=0;i<str.length()-1;i=i+2){
    if(sum <=99){
    sum += Integer.parseInt(str.substring(i, i+2));
    }else{

    sum += Integer.parseInt(str.substring(i, i+3)); 
    }
    System.out.println(sum);
}