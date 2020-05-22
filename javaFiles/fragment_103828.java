class Message {}

class TextMessage extends Message {
    String text;
}

class DataMessage extends Message {
    User user;
}