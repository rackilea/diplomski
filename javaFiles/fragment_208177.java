List<WordBean> wordList = getWordList();
    List<String> answersList = new ArrayList<String>(); 
    Random random = new Random();
    Random forAnswers = new Random();

    WordBean goodOne = wordList.get(random.nextInt(wordList.size()));
    //take it out from the list
    wordList.remove(goodOne);
    //add it to the answers list
    answersList.add(goodOne.getGermanName());
    WordBean fakeOne = wordList.get(random.nextInt(wordList.size()));
    //take it out from the list
    wordList.remove(fakeOne);
    //add it to the answers list
    answersList.add(fakeOne.getGermanName());
    WordBean fakeTwo = wordList.get(random.nextInt(wordList.size()));
    //take it out from the list
    wordList.remove(fakeTwo);
    //add it to the answers list
    answersList.add(fakeTwo.getGermanName());

    %>What is the english word for the german word <%=goodOne.getGermanName()%>

    <%
    char letter = 'A';
    for (String answer:answersList){
    %>
    <input type="radio" name="q1Answer" value=""/><label for="<%=letter%>"><%=letter%>)<%=answerList.get(forAnswers.getNextInt(3))> />
    <%
    //point to the next letter
    letter++;
    }