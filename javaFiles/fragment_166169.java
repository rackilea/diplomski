@Override
    public String saveTemplatesToPCA(List<FilesTemplateDomain> fileTemplates) {
         TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
         TransactionStatus status = transactionManager.getTransaction(transactionDefinition);
        try {
            template.saveOrUpdateAll(fileTemplates);
            transactionManager.commit(status);

            return "success";
        } catch (Exception e) {
            try{
            transactionManager.rollback(status);
            }catch(Exception ee){
                System.out.println("Exception in commit or rollback : "+ee);
            }
            System.out.println("Exception in saveTemplatesToPCA() : "+e);
            return "fail";
        }
    }