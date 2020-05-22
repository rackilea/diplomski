Iterator<T> itr = c.iterator();
T answer = itr.next();       
while(itr.hasNext()) {

    T two = itr.next();
    if(Math.abs((tm.distance(answer, val))) > Math.abs(tm.distance(two, val))) {
    answer = two; 
    }
}    
return answer;