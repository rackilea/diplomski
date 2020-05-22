TransactionTemplate newTransactionTemplate = new TransactionTemplate(platformTransactionManager);
    newTransactionTemplate.setPropagationBehavior(PROPAGATION_REQUIRES_NEW);
    Policy requireNewTransaction = new SpringTransactionPolicy(newTransactionTemplate);

    onException(RuntimeException.class)
        .onWhen(header(Header.REPLY_TO.getName()).isNotNull())
            .log(LoggingLevel.ERROR, EXCEPTION_STACKTRACE)
            .to(PROCESSOR_FOR_EXCEPTION_HANDLING)
            .to(PROCESSOR_FOR_REPLY)
            .handled(true)
            .markRollbackOnlyLast();

    from(FROM)
        .policy(requireNewTransaction)...