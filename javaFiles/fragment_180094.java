Changes changes = dbClient.changes()
    .includeDocs(true)
    .since(0)
    .heartBeat(1000)
    .filter("filters/active-doc")
    .continuousChanges();