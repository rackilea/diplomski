public class Data {
    private String code, word;
    public Data(String code, String word){
        this.code = code;
        this.word = word;
    }
    @Override
    public boolean equals(Object o){
        Data d = (Data) o;
        return this.code.equals(d.code) && this.word.equals(d.word);
    }
}