//@Transactional  (Do not require anymore)
public void refundNotAssignedVisits() {
    logger.info("Start automatic refund of past visits being assigned");

    Set<Integer> refundVisitIds = visitService.findRefundableVisitId();
    refundVisitIds.forEach( id-> {
           try {
                visitService.refund(id);
                logger.info("Visit successfully refunded!");
            }
            catch(Exception e) {
                logger.error("Error while refunding visit...", e);
            }        
     });
}