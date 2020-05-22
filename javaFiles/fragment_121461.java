List<HttpMessageConverter<?>> combined = 
       getCombinedConverters(
           converters, 
           addDefaultConverters 
               ? getDefaultConverters() 
               : Collections.emptyList());