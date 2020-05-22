List<Integer> indexArray = Arrays.asList(0, 1, 2);

Collections.shuffle(indexArray);

String question = questions[indexArray.get(0)];
String answer = answers[indexArray.get(0)];