scoreByDomicile.stream()
        .peek(i -> System.out.println(i.getName()))
        .map(obj -> {
              MetricScores i = obj.getMetricScoresList().get(0); // 
              return DomicileScore.builder()
                .id(i.getIdentifier())
                .name(obj.getName()) // obj has the original name
                .overallScore(i.getAggregatedScore())
                .appUsageScore(i.getAppUsageCompliancePercentage())
                .onTimeScore(i.getOnTimeToDestinationPercentage())
                .TenderAcceptanceScore(i.getTenderAcceptancePercentage())
                .build();
          })
         .collect(Collectors.toList());