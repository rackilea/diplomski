StringBuilder labelRow = new StringBuilder();

    // Loop over all the prediction labels in the distribution.
    for (int predictionDistributionIndex = 0; 
         predictionDistributionIndex < predictionDistribution.length; 
         predictionDistributionIndex++)
    {
        // Get this distribution index's class label.
        String predictionDistributionIndexAsClassLabel = 
            newTest.classAttribute().value(
                predictionDistributionIndex);

        // Get the probability.
        double predictionProbability = 
            predictionDistribution[predictionDistributionIndex];

        System.out.printf("[%10s : %6.3f]", 
                          predictionDistributionIndexAsClassLabel, 
                          predictionProbability );
        if(i == 0){
            labelRow.append(predictionDistributionIndexAsClassLabel+",");

            if(predictionDistributionIndex == predictionDistribution.length){
                builder.append("\n");
            }

        }

        // Add probabilities as rows     
        builder.append(predictionProbability+",");

     }
     if(i == 0){
          builder.insert(0,labelRow.toString()+"\n");
     }