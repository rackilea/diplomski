DistributedProbabilityGenerator distributedProbabilityGenerator = DistributedProbabilityGeneratorBuilder.newBuilder()
                .add(0, ofDouble(10))
                .add(1, ofDouble(45))
                .add(2, ofDouble(45))
                .build();

int generatedObjectId = distributedProbabilityGenerator.generateId();