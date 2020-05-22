AnnotationSessionFactoryBean sfb = new AnnotationSessionFactoryBean();
sfb.setDataSource( ds );
sfb.setHibernateProperties( hibProps);
sfb.setPackagesToScan( ... );
sfb.initialise();
SessionFactory sf = sfb.getObject();