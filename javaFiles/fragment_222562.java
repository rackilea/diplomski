for (int i=0; i<towns.length; i++){
    if(!towns[i].contains("p")){
        int e=0;
        for (int j=0; j<towns[i].length; j++){
            if(towns[i].charAt(j) == 'e' || towns[i].charAt(j) == 'E'){
                e++;
            }
        }
       if(e>1 && e<5){//This is assuming you don't want to print cities with more than 4 E's
           System.out.println(towns[i]);
        }
    }
}