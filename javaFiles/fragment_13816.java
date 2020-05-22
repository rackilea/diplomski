.apply(ParDo.of(new DoFn<KV<String,Integer>,KV<String,Integer>>() {
  @ProcessElement
  public void processElement(ProcessContext c) {
   if (isFirstTime) {
        myList = c.sideInput(sideData);
    }
    isFirstTime = false;
    boolean result = myList.containsKey(c.element().getKey());         
    if (result == false) {
      c.output(i);
    } 
  }
 }).withSideInputs(sideData));