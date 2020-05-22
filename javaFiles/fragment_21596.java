if(memberNoteResource.getDocumentIds()
       .stream()
       .anyMatch((id)-> repositoryService.findById(Document.class,id) == null)) {
    throw new ApiException(ApiErrorCode.DEFAULT_400, 
             "Save unsuccessful document id is not part of member note");
}