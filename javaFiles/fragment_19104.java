String autoSchemaExport = properties.getProperty(Environment.HBM2DDL_AUTO);
        if ( "validate".equals(autoSchemaExport) ) settings.setAutoValidateSchema(true);
        if ( "update".equals(autoSchemaExport) ) settings.setAutoUpdateSchema(true);
        if ( "create".equals(autoSchemaExport) ) settings.setAutoCreateSchema(true);
        if ( "create-drop".equals(autoSchemaExport) ) {
            settings.setAutoCreateSchema(true);
            settings.setAutoDropSchema(true);
    }