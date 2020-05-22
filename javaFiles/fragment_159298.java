public class MessageList extends JList{

DefaultListModel messageModel = new DefaultListModel();

  MessageRenderer messageRenderer = new MessageRenderer();

     public MessageList( ){
        this.setCellRenderer(messageRenderer);
        this.setModel(messageModel);

     }

     public void getMessage(String author, String text, String date, String tag){
         messageModel.addElement(new Message(author, text, date, tag));
     }

}