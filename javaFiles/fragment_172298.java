Map<Integer, List<String>> collect = answers
         .stream()
          .collect(Collectors.groupingBy(
                Answer::getQuestion,
                Collectors.mapping(Answer::getAnswerAsString, Collectors.toList())       
));