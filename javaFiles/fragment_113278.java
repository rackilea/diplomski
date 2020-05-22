ConnectionProvider connectionProvider = null;
    String providerClassName = getConfiguredConnectionProviderName( configurationValues );
    if ( providerClassName != null ) {
        connectionProvider = instantiateExplicitConnectionProvider( providerClassName, classLoaderService );
    }
    else if ( configurationValues.get( Environment.DATASOURCE ) != null ) {
        connectionProvider = new DatasourceConnectionProviderImpl();
    }

    if ( connectionProvider == null ) {
        if ( c3p0ConfigDefined( configurationValues ) && c3p0ProviderPresent( classLoaderService ) ) {
            connectionProvider = instantiateExplicitConnectionProvider( C3P0_PROVIDER_CLASS_NAME,
                    classLoaderService
            );
        }
    }

    if ( connectionProvider == null ) {
        if ( proxoolConfigDefined( configurationValues ) && proxoolProviderPresent( classLoaderService ) ) {
            connectionProvider = instantiateExplicitConnectionProvider( PROXOOL_PROVIDER_CLASS_NAME,
                    classLoaderService
            );
        }
    }

    if ( connectionProvider == null ) {
        if ( configurationValues.get( Environment.URL ) != null ) {
            connectionProvider = new DriverManagerConnectionProviderImpl();
        }
    }

    if ( connectionProvider == null ) {
        LOG.noAppropriateConnectionProvider();
        connectionProvider = new UserSuppliedConnectionProviderImpl();
    }