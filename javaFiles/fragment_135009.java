class WeatherObserver extends Observer {
   public WeatherObserver(Subject subject) {
      super(subject);
   }

   public void addSubject(Subject subject){
      subject.attachObserver(this);
   }

   @Override
   public void update(Subject subject) {
      if (subject instaceof TemperatureSensor){
          TemperatureSensor temp=(TemperatureSensor)subject;        
          System.out.println("Temperature: " + temp.getTemperature() + " Celcius");
      } else if (subject instaceof PressureSensor ){
          PressureSensor press=(PressureSensor)subject;
          // use press
      } else if (subject instaceof HumiditySensor ){
          HumiditySensor humid=(HumiditySensor)subject;
          // use humid
      } else {
          throw new ClassCastExeption("Unexpected instance of Subject: " + subject.getClass());
      }
    }    
 }