List<String> filepaths = new ArrayList<String>("filepath1", "filepath2", "filepathMissing");

return pipeline
    .apply("GatherFiles", Create.of(filepaths)).setCoder(StringUtf8Coder.of())
    .apply("GatherFileData", TextIO.readAll().withEmptyMatchTreatment(EmptyMatchTreatment.ALLOW))        
    .apply("ApplyCustomDoFn", ParDo.of(new CustomDoFn()))
    .apply("Group", GroupByKey.<String, String>create())
    .apply("AnotherCustomDoFn", ParDo.of(new AnotherCustomDoFn()));