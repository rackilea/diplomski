SimpleJasperReportsContext context = new SimpleJasperReportsContext();
FileRepositoryService fileRepository = new FileRepositoryService(context, "D:/MyProgram/src/myprogram/", false);
context.setExtensions(RepositoryService.class, Collections.singletonList(fileRepository));
context.setExtensions(PersistenceServiceFactory.class, Collections.singletonList(FileRepositoryPersistenceServiceFactory.getInstance()));

JasperPrint jasperPrint = JasperFillManager.getInstance(context).fill(jasperReport, params);