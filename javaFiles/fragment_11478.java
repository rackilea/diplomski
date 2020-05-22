List<ServiceRequest> targets = new ArrayList<ServiceRequest>();
for(Iterator<ServiceRequest> it = targets.iterator(); it.hasNext();) {
    ServiceRequest currentServReq = it.next();
    if(someCondition) {
        it.remove();
    }
}