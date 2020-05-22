List<Query> finalQueries = updatedQueries
    .stream().filter(query->{
        Period period = getPeriodRequest(query);
        return periodService.validatePeriodicity(period )&& isMandatory(period))
    })
    .collect(Collectors.toList());