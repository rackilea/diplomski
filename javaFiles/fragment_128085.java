public class Framo extends Frame {

            public Framo() {
                setLayout(new FlowLayout());
                Panel panel = new Panel();
                Button btn = new Button("press");
                panel.add(btn);

                add(panel);
                setSize(400, 400);
                setVisible(true);
            }

            public static void main(String[] args) {
                Framo f = new Framo();

            }

   }