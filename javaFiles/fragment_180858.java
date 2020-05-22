Page<Message> results = repository.findAll(predicate, pageable);
    Converter<? super Message, ? extends MessageSummary> converter= l -> {
        if(l instanceof TextMessage){
            return projectionFactory.createProjection(TextMessageSummary.class,l);
        }
        else if(l instanceof TodoMessage){
            return projectionFactory.createProjection(TodoMessageSummary.class,l);
        }
        else { 
            return projectionFactory.createProjection(MessageSummary.class,l);
        }
    };
    Page<MessageSummary> projected =results.map(converter);
    return pagedAssembler.toResource(projected);