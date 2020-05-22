Changes changes = dbClient.changes()
    .includeDocs(true)
    .since(0)
    .heartBeat(1000)
    .selector("{\"selector\": { \"_deleted\": {\"$exists\":  false}}}")
    .continuousChanges();