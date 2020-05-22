public ArrayList<OEntityHolder> doInBackground(Void... params) {
    String [][] urls = {{"http:MyUrl/ZMOB_FECODSet", "Name1", "Fecod"},
                        {"http:MyUrl/ZMOB_OTEILSet", "Name2", "Oteil"},
                        {"http:MyUrl/ZMOB_KUNNRSet", "Name3", "Kunnr"},
                        {"http:MyUrl/ZMOB_BAULTSet", "Name4", "Bault"}};
    for (String [] urlProp:urls) {
        //Here you get the list of entities from the url
        List<OEntity> listEntities = ODataJerseyConsumer.create(urlProp[0]).getEntities("MYENTITYTOCONSUME").execute().toList();
        for (OEntity entity:listEntities) {
            OEntityHolder holder = new OEntityHolder(entity);
            for (int i = 1; i < urlProp.length; i++)
                holder.addProperty(urlProp[i]);
            zmob_entity_holders.add(holder);
        }
    }
    //At this point, all of the entities associated with the list of URLS will be added to the list
    return zmob_entity_holders;
}