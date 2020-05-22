String line = reader.readLine();
  String answerKey = line;
  StringTokenizer tokens;
  while((line = reader.readLine()) != null) {
    tokens = new StringTokenizer(line);
    studentID[total] = Integer.parseInt(tokens.nextToken());
    studentAnswers[total] = tokens.nextToken();
    total++;
  }