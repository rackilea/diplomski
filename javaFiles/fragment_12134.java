UpdateOperations<BatchData>updateOperations=mongo.createUpdateOperations
             (BatchData.class)
            .disableValidation().set("fileObjects.$.fileHash",hash).enableVali..;

mongo.update(mongo.createQuery(BatchData.class)
            .filter("uuid",theBatch.uuid)
            .filter("fileObjects.fileName","theFileName"),updateOperations);