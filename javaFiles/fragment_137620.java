public class ExperimentToStringConverter implements  Converter<Experiment,String>{

      public String convert(Experiment experiment){
         return String.valueOf(experiment.getExperimentId());
      }
  }