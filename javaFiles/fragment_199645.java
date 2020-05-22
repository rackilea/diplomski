.apply(ParDo.of(new DoFn<String, ClassxNorms>() { 
    @ProcessElement
    public void processElement(ProcessContext c) throws ParseException {
      String[] strArr = c.element().split(",");
      ClassxNorms xn = new ClassxNorms();
      double sample = new GammaDistribution(Double.parseDouble(strArr[11]), Double.parseDouble(strArr[12])).cumulativeProbability(Double.parseDouble(strArr[6]));
      xn.setDuration(Double.parseDouble(strArr[6]));
      xn.setAlpha(Double.parseDouble(strArr[11]));
      xn.setBeta(Double.parseDouble(strArr[12]));
      xn.setVolume(Double.parseDouble(strArr[13]));
      xn.setSpend(Double.parseDouble(strArr[14]));
      xn.setEfficiency(Double.parseDouble(strArr[15]));
      xn.setXnorm(Double.parseDouble(strArr[16]));
      xn.setKey(strArr[17]);
      xn.setGamma(sample);
      c.output(xn);
    }
  }));