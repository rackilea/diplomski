for(int i=0;i<str.length()-1; /* removed incrementation */){
    if(sum <=99){
        sum += Integer.parseInt(str.substring(i, i+2));
        i=i+2;
    }else{
        sum += Integer.parseInt(str.substring(i, i+3)); 
        i=i+3;
    }
    System.out.println(sum);
}