//Cannel by visitorId and load the Visitor by Id in a new transaction
@Override
@Transactional(propagation = Propagation.REQUIRES_NEW)
public Visit cancel(Integer visitorId) throws Exception {
    Visit visit=  session.get(Visit.class , visitorId); 
    cancel(visit); 
}

@Override
public Visit cancel(Visit visit) throws Exception {
    // Some business logic
}

//Add method to return the IDs only
@Transactional(readOnly=true)
public Set<Integer> findRefundableVisitId(){

}