public static double[] randomRainMonth(){
      //this method should be responsible to create the double array object 
      //and then return it to the caller after populating with elements
      double [] monthRain = new double[12];

      for(int i = 0; i < list.length; i++){
        rdMonth[i] = (int)(Math.random() * 100);
        //System.out.println(rdMonth[i]);
      }
      return monthRain;
  }