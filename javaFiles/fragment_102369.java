public BaseDocument map(CmsDocument cmsDocument) {
    BaseDocument document = documentsMapperFactory.getMapper(cmsDocument.getType()).map(cmsDocument);

    // Call init 
    document.init(cmsDocument);

    return document;
}