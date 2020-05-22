Mapper mapper = new Mapper();
CmsDocument cmsDocument = ...

BaseDocument doc = mapper.map(cmsDocument, BaseDocument.class);

DownloadAppComponent downloadAppComponent = (DownloadAppComponent) mapper.map(cmsDocument, DownloadAppComponent.class);