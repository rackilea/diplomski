Result<?> fetch = this.ctx 
                     // .. 
                     .fetch();

for(Record record : fetch) {            
    String value = record.getValue(STORE_ITEM_DETAILS.NAME);            
    System.out.println(value);
}