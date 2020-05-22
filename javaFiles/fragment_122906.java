public class ChatPanel extends JPanel implements Outlet {
    //...

    @Override
    public void say(String text) {
        chatArea.append(text + NEWLINE);
    }

}