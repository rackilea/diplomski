return Arrays.stream(array)
            .collect(Collector.of(
                          JSONArray::new, //init accumulator
                          JSONArray::put, //processing each element
                          JSONArray::put  //confluence 2 accumulators in parallel execution
                     ));