public int savePostingPaymentDetails(List<Posting> postingsToUpdate, List<PaymentPostingDetail> detailsToInsert, Payment payment) {

    int returnCode = 1 // 1 -> "success" , 0 -> "failure"

    logger.info("DB ACCESS : INSERT PAYMENT DETAILS & UPDATE POSTINGS");
    long begin = System.nanoTime();
    long end = 0;

    this.em.getTransaction().begin();

    try {
        // TEST
        // 1 - Save Payments
        this.em.persist(payment);

        // 2 - Save Details
        for (PaymentPostingDetail ppd : detailsToInsert) {
            this.em.persist(ppd);
        }

        // 3 - Update Postings
        for (Posting p : postingsToUpdate) {
            if(p.getSignature() != null)
            {
                p.getSignature().setModification("withholding-tax.pay", new Date());
            }
            else
            {
                logger.error("The Posting with id = " + p.getIdentifier() + " has no PersistenceSignature ?!");
            }
            this.em.merge(p);
        }
        this.em.getTransaction().commit();
        end = System.nanoTime();
    }
    catch (Exception e)
    {
        returnCode = 0;
        logger.error("Unexpected error on saving/updating the DB.", e);

        this.em.getTransaction().rollback();
        logger.info("RollBack done.");

        // e.printStackTrace();
         System.exit(JobStatus.ABNORMAL_END_OF_EXECUTION_ERROR.getCode());
        return returnCode;
    }

    //this.em.getTransaction().commit();
    logger.info("Details inserted & Postings updated.");

    //long end = System.nanoTime();
    logger.info("Execution time = " + ((end-begin) / 1000000) + " milliseconds.");
    logger.info("----------------------------------------------------------");
    return  returnCode = 1;
}