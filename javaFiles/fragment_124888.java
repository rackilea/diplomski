public enum RecordField {

    ACTION_ID(Pattern.compile("[A-Z0-9]{4}")),
    TYPE(Pattern.compile("0[1|2|4|5]"));

    private Pattern regex;

    RecordField(Pattern s) {
        this.regex = s;
    }

    public Boolean matches(String text){
        return regex.matcher(text).find();
    }

}