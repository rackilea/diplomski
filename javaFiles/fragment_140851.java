@Autowired
private TransactionTemplate transactionTemplate;

@Scheduled(fixedDelay = 100L)   
public void updateWidgets(List<Long> ids) {  
    for(long id: ids){
       transactionTemplate.execute(new TransactionCallbackWithoutResult() {
          protected void doInTransactionWithoutResult(TransactionStatus status) {
              Widget w = widgetDAO.getWidget(id);
               doSomeStuff(w);
               widgetDAO.saveWidget(w);
          }
    }   
}