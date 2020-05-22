private void writeObject(java.io.ObjectOutputStream out) throws IOException {
    out.writeString(question);
    out.writeString(answer1);
    out.writeString(answer2);
    out.writeString(answer3);
    out.writeInt(correctAnswer);
}