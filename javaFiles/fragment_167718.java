public ParametrisationByDelimitedName() {
        useConfiguration(new MostUsefulConfiguration()
                .useParameterControls(new ParameterControls().useDelimiterNamedParameters(true))
                .useStoryReporterBuilder(
                        new StoryReporterBuilder().withFormats(Format.CONSOLE)));
    }