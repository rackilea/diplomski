List<String> columnsList = getColumns(service.getColumns());

List<Attribute<?>> attributes = beClient.getAttributes(columnsList);

for (String column : columnsList) {
    boolean isPresent =false;
    boolean isSuccess = true;

    for(Attribute<?> attr : attributes) {
        if(attr.getName().equals(column)){
            isPresent = true; 
        }       
        if(!attr.getStatus().equals("SUCCESS")){
            isSuccess = false; 
        }
    }

    if(!isPresent || !isSuccess){
        foundData=false; 
    }else{
        count_success.incrementAndGet();
    }   
}