private String basepath = VaadinService.getCurrent()
            .getBaseDirectory().getAbsolutePath();
private Button saveExcel = new Button();
Resource res = new FileResource(new File(basepath +
                "/WEB-INF/docs/settings.xlsx"));
FileDownloader fd = new FileDownloader(res);
fd.extend(saveExcel);