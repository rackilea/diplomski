public BaseDocument map(CmsDocument cmsDocument) {
    BaseDocument document = documentsMapperFactory.getMapper(cmsDocument.getType()).map(cmsDocument);

    // Call setCommonValues to remove duplication of code
    setCommonValues(document, cmsDocument);
    return document;
}