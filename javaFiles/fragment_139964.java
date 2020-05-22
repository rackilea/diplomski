//Define template location 
        Bundle bundle = FrameworkUtil.getBundle(getClass());
        URL fileUrl = FileLocator.toFileURL(FileLocator.find(bundle, new Path('fileTemplates/'), null));`

        /* Define velocity engine and template */
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.FILE_RESOURCE_LOADER_PATH, fileUrl.getPath());
        ve.init();
        Template t = ve.getTemplate("DCM_Default.vm");