Uats {
        testInstrumentationRunner "com.quandoo.gradletestpoc.test.Instrumentation"

        // passing instrumentation parameters
        buildConfigField "String", "TAGS", "\"${getTagsProperty()}\""
    }