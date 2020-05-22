class Dictionary implements Serializable {
    private List<Words> wordsList = new ArrayList<>();


    List<Words> getWordsList() {
        return wordsList;
    }

    void setWordsList(List<Words> wordsList) {
        this.wordsList = wordsList;
    }
}