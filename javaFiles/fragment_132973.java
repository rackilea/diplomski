private void setNumFound(String num){
    List<Predicate<String>> runnableNumList = Arrays.asList(
            this::isStringOne,
            this::isStringTwo,
            this::isStringThree
    );

    for (Predicate<String> runnableNum : runnableNumList){
        if (runnableNum.test(num)){
            this.numFound = true;
        }
    }
}