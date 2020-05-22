QueryResults<MoIADocument> foundResults = dao.find(query);
List<MoIADocument> list = foundResults.asList();
for (MoIADocument obj : list) {
    //do modifications in obj
    dao.save(obj);
}