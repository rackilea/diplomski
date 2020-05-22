final List<String> result = new ArrayList<String>();

    final List<String> textList= getList(); // get your list

    final StringTokenizer tokenizer = 
      new StringTokenizer(textList, delimiter); // your delimiter
    while (tokenizer.hasMoreElements()) {
      final String token = tokenizer.nextToken();
      if (isValid(token)) { // implement your own isValid method
        result.add(token);
      }

    }
    return result;