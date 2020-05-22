for (Aggregation aggs : aggregations) {

         Sum sum = (Sum) aggs;
         double sumValue = sum.getValue();
          System.out.println("sumValue=" + sumValue);
  }