public <NextOut> PipelineBuilder<In, NextOut> add(Stage<Out, NextOut> stage)
{
    stages.add(stage);

    // This cast is safe as per construction of the pipeline
    @SuppressWarnings("unchecked")
    PipelineBuilder<In, NextOut> result = 
        (PipelineBuilder<In, NextOut>) this;
    return result;
}