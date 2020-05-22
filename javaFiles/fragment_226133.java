ObjectId blobId = getObjectId( 0 );
ObjectReader objectReader = repository.newObjectReader();
ObjectLoader objectLoader = objectReader.open( blobId );
byte[] bytes = objectLoader.getBytes();
objectReader.close();
booloean binary = RawText.isBinary( bytes );