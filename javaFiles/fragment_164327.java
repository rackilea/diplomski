while(m.find()){
    if(m.group(1) != null){
        delQuotes = m.group(1).replace("\"", "");
    if(count == 0){
        data[noOfRows][count ] = delQuotes;
        System.out.println(delQuotes);
    }
    if(count == 1){
        data[noOfRows][count ] = delQuotes;
    }
    if(count == 2){
        data[noOfRows][count] = delQuotes;
        data[noOfRows][count+1] = "Delete";
    }
    }
    if(count < column.length) count++;
}