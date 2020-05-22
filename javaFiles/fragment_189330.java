class Question {
    String thoughts 

    static mapping = {
        table "QUESTION"
        id column: "QUESTION_ID"
        thoughts column: "THOUGHTS", type: "text"
    }
}