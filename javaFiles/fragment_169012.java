interface Message{
     public void accept(MessageVisitor visitor);
}

interface MessageVisitor{
    public void visit(TextMessage message);
    public void visit(AudioMessage message);
}

class PrintVisitor implements MessageVisitor{
    public void visit(TextMessage message){
         //print text message
    }

    public void visit(AudioMessage message){
        //do step required
    }
}

class TextMessage implements Message{
     //other methods

     public void accept(MessageVisitor visitor){
          visitor.visit(this);
     }
}