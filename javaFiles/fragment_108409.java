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