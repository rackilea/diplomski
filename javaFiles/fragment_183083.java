public static void main(String[] args) {
    Question q = new Question();
    q.questionText = "this \" has some :\" characters that need \\escaping \\";

    Gson g = new Gson();
    String json = g.toJson(q);
    System.out.println(json);
}

public static class Question{
    public String questionText;
    //getters and setters.
}