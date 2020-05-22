List<Datasetstatus> dobj=
    (List<Datasetstatus>) session.createSQLQuery(
    "SELECT ds " +
    "from datasetstatus ds " +
    "where ds.datasetId = :dataSetId")
.setParameter("dataSetId", meta_dataset)
.list();