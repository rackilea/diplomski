// ...
public MyFrame() {
     setLayout(new BorderLayout());
     add(view, BorderLayout.CENTER);
     setDefaultCloseOperation(EXIT_ON_CLOSE);
     // Activate autolayout here : 
     viewer.enableAutoLayout();
}
// ...