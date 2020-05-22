for(int i = 1; i <= 2500; i++){
    if(val.prime(i)==i){
        System.out.println(i);
    }
    else if(val.divall(i)==2){
        break;
    }
    else if(val.div3(i)==0){
        System.out.println(i + "");
    }
    else if(val.div8(i)==0){
        System.out.println(i);
    }
}