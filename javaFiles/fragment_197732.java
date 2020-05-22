Jframe app;
JLabel label;
    public static void main(String[] args) {
           new myProject();
        }

    public myProject()
    {
          app = new JFrame();
          app.setTitle // and all that jazz...        
          label = new JLabel();
          label.setText("Old text");
          app.add(label);
    }
      public void mouseClicked(MouseEvent e) {
          app.setTitle("New Title");
          label.setText("New text");
          System.out.println(x);
      }