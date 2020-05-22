@AfterReturning(value="(execution(* find(..)) )" +
            "&& target(com.erp.core.service.IBaseApplicationService) " +
            "&& args(queryKey,object,..)",returning="returnList")
    public void **print(String queryKey, Object[] object,List returnList)**
    {
        System.out.println("find method called");
    }