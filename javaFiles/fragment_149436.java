for (String serviceCode : serviceCodes) {
    FlatFileItemWriter  writer  =genevaDetailsWriter(serviceCode, countryKey); 
    writer.open (new ExecutionContext ());
    map.put(serviceCode, writer);

    }