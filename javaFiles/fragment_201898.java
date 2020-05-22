private void writeObject(java.io.ObjectInputStream in) throws IOException,ClassNotFoundException {
        question = in.readString();
        answer1 = in.readString();
        answer2 = in.readString();
        answer3 = in.readString();
        correctAnswer = in.readInt();
    }