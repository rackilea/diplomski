import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

interface Stage<In, Out>
{
    DataItem<Out> processItem(DataItem<In> data) throws Exception;
}

class DataItem<T>
{
    public T data;

    public DataItem(T obj)
    {
        this.data = obj;
    }
}

class Pipeline<In, Out> implements Stage<In, Out>
{
    private List<Stage<?, ?>> stages;

    Pipeline(List<Stage<?, ?>> stages)
    {
        this.stages = stages;
    }

    @Override
    public DataItem<Out> processItem(DataItem<In> dataItem) throws Exception
    {
        DataItem<?> current = dataItem;
        for (Stage<?, ?> stage : stages)
        {
            current = apply(stage, current);
        }

        // This cast is safe as per construction of the pipeline
        @SuppressWarnings("unchecked")
        DataItem<Out> result = (DataItem<Out>) current;
        return result;
    }

    private <I, O> DataItem<O> apply(
        Stage<I, O> stage, DataItem<?> dataItem) throws Exception
    {
        // This cast is safe as per construction of the pipeline
        @SuppressWarnings("unchecked")
        DataItem<I> typedDataItem = (DataItem<I>)dataItem;
        DataItem<O> result = stage.processItem(typedDataItem);
        return result;
    }
}

class PipelineBuilder<In, Out>
{
    private List<Stage<?, ?>> stages;

    static <In, Out> PipelineBuilder<In, Out> create(Stage<In, Out> stage)
    {
        PipelineBuilder<In, Out> pipelineBuilder = 
            new PipelineBuilder<In, Out>(stage);
        return pipelineBuilder;
    }
    private PipelineBuilder(Stage<In, Out> stage)
    {
        stages = new ArrayList<Stage<?,?>>();
        stages.add(stage);
    }
    public <NextOut> PipelineBuilder<In, NextOut> add(Stage<Out, NextOut> stage)
    {
        stages.add(stage);

        // This cast is safe as per construction of the pipeline
        @SuppressWarnings("unchecked")
        PipelineBuilder<In, NextOut> result = 
            (PipelineBuilder<In, NextOut>) this;
        return result;
    }

    public Pipeline<In, Out> build()
    {
        return new Pipeline<In, Out>(stages);
    }
}

public class PipelineExample
{
    public static void main(String[] args) throws Exception
    {
        showBasicUsage();
        showHowNiceItIsToUseAnInterface();
    }

    private static void showBasicUsage() throws Exception
    {
        Pipeline<String, Integer> pipeline = createExamplePipeline();

        DataItem<String> in = new DataItem<>("1 35 42 2 10 5 2 3");
        DataItem<Integer> out = pipeline.processItem(in);

        System.out.println(out.data); // prints 100   
    }


    private static void showHowNiceItIsToUseAnInterface() throws Exception
    {
        Stage<List<Integer>, String> stringCreator = 
            dataItem -> new DataItem<>(
                dataItem.data.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" ")));

        // Create the whole pipeline that was used in the basic usage
        // example, and use it as one stage in the new pipeline:
        Stage<String, Integer> pipelineAsStage = createExamplePipeline();

        Pipeline<List<Integer>, Integer> pipeline = PipelineBuilder
            .create(stringCreator)
            .add(pipelineAsStage)
            .build();

        DataItem<List<Integer>> in = new DataItem<>(Arrays.asList(0,1,2,3,4));
        DataItem<Integer> out = pipeline.processItem(in);

        System.out.println(out.data); // prints 10   
    }

    private static Pipeline<String, Integer> createExamplePipeline()
    {
        Stage<String, String[]> splitter = 
            dataItem -> new DataItem<>(dataItem.data.split(" "));
        Stage<String[], List<Integer>> transformer = 
            dataItem -> new DataItem<>(Arrays.stream(dataItem.data)
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
        Stage<List<Integer>, Integer> accumulator = 
            dataItem -> new DataItem<>(
                dataItem.data.stream().reduce(0, Integer::sum));

        Pipeline<String, Integer> pipeline = PipelineBuilder
            .create(splitter)
            .add(transformer)
            .add(accumulator)
            .build();

        return pipeline;
    }



    private static void showTypeTransitions()
    {
        Stage<String, String[]> s0 = null;
        Stage<String[], List<Integer>> s1 = null;
        Stage<List<Integer>, Integer> s2 = null;

        // Starting with a builder for a Pipeline<String, String[]>
        PipelineBuilder<String, String[]> b0 = PipelineBuilder.create(s0);

        // Appending a Stage<String[], List<Integer>> turns it 
        // into a builder for a Pipeline<String, List<Integer>>
        PipelineBuilder<String, List<Integer>> b1 = b0.add(s1);

        // Appending a Stage<List<Integer>, Integer> turns it 
        // into a builder for a Pipeline<String, Integer>
        PipelineBuilder<String, Integer> b2 = b1.add(s2);

        // Finally, build it
        Pipeline<String, Integer> pipeline = b2.build();
    }

}