List<StorageObject> storageObjects = new ArrayList();
    torage.Objects.List listObjects = storage.objects().list(bucket);
    Objects objects = listObjects.execute();
    storageObjects.addAll(objects.getItems());
    for (StorageObject storageObject : workBucketObjects) {
           Storage.Objects.Delete delete = storage.objects().delete(bucketName,storageObject.getName());
           delete.execute();