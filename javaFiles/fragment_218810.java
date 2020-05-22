try{
    setLogParams(company_id, userId);
    ... // do your business logic
} finally {
    clearLogParams(); // Something like ThreadContext.clear();
}