class TextModule {
    private final String summary;

    public TextModule(String summary){
        this.summary=summary;
    }

    public String getSummary(){ return summary; }

    @Override
    public String toString(){
        return summary;
    }
}