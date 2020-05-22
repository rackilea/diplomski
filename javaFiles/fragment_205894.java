public static final List<String> MY_LIST = new ArrayList<String>() {{
    addAll(Arrays.asList(new String [] { "Java","Python","Lisp","C#"}));
    addAll(SUB_LIST);
}} ;

public static final List<String> SUB_LIST = Arrays.asList(new String [] {
        "Cobol","Pascal"});