Queue queue = QueueFactory.getQueue("backupQueue");
TaskOptions taskOptions = withUrl("/_ah/datastore_admin/backup.create")
            .method(TaskOptions.Method.GET)
            .param("name", 'Backuptask')
            .param("filesystem", "gs")
            .param("gs_bucket_name", BACKUP_BUCKET + '/' + DateTime.now().toString("yyyy/MM/dd/'" + nameSpace + "'-HH-mm"))
            .param("namespace", NamespaceManager.get();)
            .param("queue", queue.getQueueName())
            .param("kind", "customer")
            .param("kind", "address");
queue.add(taskOptions);