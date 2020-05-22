Observable.just(repository.getFileNotUploaded()).flatMapIterable ( files -> file)
// OR 
Observable.flatmapIterable(repository.getFileNotUploaded())

.flatMap(entity -> rs.uploadFile(new File(yourPath, entity.getLocalPath())) // for each file not uploaded run another observable and return it
.map(entity -> { entity.setFieldUrl(fileUrl); return entity; }) // modify the entity and return it
.toList() // get it back to List<String> with your entities
.flatMap(entityList -> uploadEntityObservable(entityList))
.subscribe( 
    success -> Log.d("Success", "All entities and files uploaded"), 
    error -> Log.e("Error", "error happened somewhere")
);