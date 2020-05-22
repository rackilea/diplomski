// First map messages to counts
HashMap<String,Integer> messageCounts = new HashMap<>();
errorResponse.getItems().forEach( errorMessage -> {
    messageCounts.putIfAbsent( errorMessage.getMessage(), 0 );
    messageCounts.computeIfPresent( errorMessage.getMessage(), (k,v) -> v+1 );
});

// Then create the summary objects
List<ErrorMessages> summaries = 
    messageCounts.entrySet().stream().map( e -> {
        ErrorMessage summary = new ErrorMessage();
        summary.setMessage( e.getKey() );
        summary.setTotal( e.getValue() );
        return summary;
    } ).collect( Collectors.toList() );

errorResponse.setItems( summaries );