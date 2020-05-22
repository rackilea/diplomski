List<Integer> dobj=
    (List<Integer>) session.createSQLQuery(
        "SELECT ds.datasetstatusID " +
        "from datasetstatus ds " +
        "where ds.datasetId = :dataSetId")
    .setParameter("dataSetId", meta_dataset)
    .list();