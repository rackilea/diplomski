public class FirstProcessor implements ItemProcessor<String, String> {...}


public class SecondProcessor implements ItemProcessor<String, OtherClass> {

  public OtherClass process(String item) throws Exception {

     return otherClassObjectWithDataForNextProcessor;

  }
}

public class ThirdProcessor implements ItemProcessor<OtherClass, TargetClass> {...}

public class CustomItemWriter implements ItemWriter<TargetClass> {...}