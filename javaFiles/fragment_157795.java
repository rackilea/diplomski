for( int i=0; i < al1.size(); i++ ){
    for( int j = al1.size()-1; j > i; j-- ){

        if( al1.get(i).equals(al1.get(j)) ){
            ArrayList temp1 = (ArrayList)al4.get(i);
            ArrayList temp2 = (ArrayList)al4.get(j);
            for(int k=0;k<temp1.size();k++){
                if(!temp2.get(k).equals("0")){
                    temp1.set(k, temp2.get(k));
                }
            }
            al1.remove(j);
            al4.remove(j);
            al4.set(i, temp1);
        }
    }    
}