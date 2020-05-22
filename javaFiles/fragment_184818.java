private ChatBox box = new ChatBox(this); //is this legal in java?
                                  ^^^^
public void OnTextSet(String s){
    System.out.println(s);      
}

//elsewhere
private MessageWindow mw;
public ChatBox(MessageWindow mw) {
               ^^^^^^^^^^^^^^^^
   this.mw = mw

...
public void keyReleased(KeyEvent e) {
...
   mw.OnTextSet(sendText);
}