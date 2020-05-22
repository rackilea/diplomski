Dataset<FeaturesAndLabelData> featuresAndLabelData = inputDf.select("value").as(Encoders.STRING())
  .flatMap(s -> {
    String[] splitted = s.split(",");
    if (splitted.length == 3) {
      return Collections.singleton(new FeaturesAndLabelData(
        Double.parseDouble(splitted[0]),
        Double.parseDouble(splitted[1]), 
        Integer.parseInt(splitted[2]))).iterator();
    } else {
      // apply some error handling...
      return Collections.emptyIterator();
    }
  }, Encoders.bean(FeaturesAndLabelData.class));