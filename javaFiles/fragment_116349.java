for(CustomObj__c i:customList){
    for(CustomObj__c j:customList2){
        if(j.id == i.id){
           temp = new list<string>();
           temp.add(j.Contact__r.Owner.Id);
           temp.add(j.Contact__r.Id);
           result.put(i.Deal__r.id, temp);
           break;
        }                
    }
}