List<Matcher<? super String>> matchersList = new ArrayList<>();
        matchersList.add(Matchers.equalTo("a"));
        matchersList.add(Matchers.equalTo("b"));

        // no illegal cast anymore
        Mockito.verify(mock).doSomething(
            (Collection<String>) argThat(Matchers.contains(matchersList)));