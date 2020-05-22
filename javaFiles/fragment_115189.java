combined.addAll(sampleModels_two);
        combined.addAll(sampleModels_one);

        Set<SampleModel> hs = new LinkedHashSet<>();
        hs.addAll(sampleModels_one);
        hs.addAll(sampleModels_two);
        combined.clear();
        combined.addAll(hs);