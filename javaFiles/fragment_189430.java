private class Make {
@Fields({
        @Field(name = "name", analyzer = @Analyzer(definition = "searchtokenanalyzer")),
        @Field(name = "label", analyze = Analyze.NO)
    })
    private String name;
}