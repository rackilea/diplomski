@PropertySources({
        @PropertySource("classpath:emulator.properties"),
        @PropertySource(value = "file://${emulator.config}", ignoreResourceNotFound = true),
        @PropertySource("classpath:statsd.properties"),
        @PropertySource(value = "file://${statsd.config}",ignoreResourceNotFound = true),
        @PropertySource("classpath:pools.properties"),
        @PropertySource(value = "file://${pools.config}",ignoreResourceNotFound = true),
        @PropertySource("classpath:db.properties"),
        @PropertySource(value= "file://${db.config}",ignoreResourceNotFound = true)
        })