HiveMetaStoreClient metastoreClient = null;
HiveConf hiveConf = new HiveConf();         
metastoreClient = new HiveMetaStoreClient(hiveConf);
List<FieldSchema> list = metastoreClient.getFields(<database_name>,<table_name>);   
for (int i = 0; i < list.size(); i++) {
    System.out.println("Column names : "+list.get(i).getName());        
}                   
metastoreClient.close();