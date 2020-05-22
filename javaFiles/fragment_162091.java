if(cityGraph[startNode][i] == 1){
    if( i == city2 ){ 
        System.out.println("yes");
        return;
    }//if city2 found
    q.add(i);
    cityGraph[startNode][i] = 0; //Set to visited
}//if vertex exist