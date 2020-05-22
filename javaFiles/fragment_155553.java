package com.example.configuration;

import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.boot.spi.SessionFactoryBuilderFactory;
import org.hibernate.boot.spi.SessionFactoryBuilderImplementor;
import org.slf4j.LoggerFactory;

import com.example.CustomType;

public class CustomDataTypesRegistration implements SessionFactoryBuilderFactory {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CustomDataTypesRegistration.class);

    @Override
    public SessionFactoryBuilder getSessionFactoryBuilder(final MetadataImplementor metadata, final SessionFactoryBuilderImplementor defaultBuilder) {
        logger.info("Registering custom Hibernate data types");
        metadata.getTypeResolver().registerTypeOverride(CustomType.INSTANCE);
        return defaultBuilder;
    }
}