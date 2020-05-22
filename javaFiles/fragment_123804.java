Object marketFilter = filter.getAllMarket();
Object cmtsFilter = filter.getAllCmts();
Object packageFilter = filter.getAllPackage();
Object nodeFilter = filter.getAllNodes();


if(marketFilter != null){
    query.addFilterField("_id.market", MongoQuEry.OP_IN, filter.getMarket());
}
.
.
. upto filter N

String collectionName = getCollectionName(marketFilter, ... filter N)

/* 
 create a function getCollectionName(filter1, ... filterN)   
  in this function you can generate collection name by checking which 
  filters are not null.
*/