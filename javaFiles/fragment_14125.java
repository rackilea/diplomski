Properties jobProperties = MassIndexingJob.parameters()
        .forEntity( MyClass.class )
        .restrictedBy( Restrictions.ge( "lastChangeDateTime", LocalDate.now().minus( 26, ChronoUnit.HOURS ) ) // 26 to account for DST switch and other slight delays
        .build();
long executionId = BatchRuntime.getJobOperator()
        .start( MassIndexingJob.NAME, jobProperties );