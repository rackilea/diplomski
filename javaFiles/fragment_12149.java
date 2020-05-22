private static final String GRID_FS_FILES_COLLECTION_NAME = "fs.files";
private static final String GRID_FS_CHUNKS_COLLECTION_NAME = "fs.chunks";

@Autowired
protected MongoOperations mongoOperations;

mongoOperations.getCollection(GRID_FS_FILES_COLLECTION_NAME).setWriteConcern(WriteConcern.ACKNOWLEDGED);
mongoOperations.getCollection(GRID_FS_CHUNKS_COLLECTION_NAME).setWriteConcern(WriteConcern.ACKNOWLEDGED);