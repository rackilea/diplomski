class clienttime_gui
{
static JLabel output=new JLabel();// Declare JLabel here.

public static void main(String args[]) throws Exception
{   
    JFrame frame=new JFrame("Add IP");
    JTextField textbox;
    JButton button;
    JLabel label;

    frame.setLayout(null);
    textbox = new JTextField();
    textbox.setBounds(100,20,150,20); 
    label = new JLabel("Add IP");
    label.setBounds(50, 20, 100, 20);
    button=new JButton("Submit");
    button.setBounds(250,20,100,20);
    frame.add(textbox);
    frame.add(label);
    frame.add(output);
    frame.add(button);
    final String x=textbox.getText();
   frame.setSize(400,100);
    frame.setVisible(true);  
    button.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1) {
                try{

                InetAddress locIP = InetAddress.getByName(x);
                //InetAddress locIP = 
                         InetAddress.getByName("14.139.60.104");
                Socket soc= new Socket(locIP,7681);
                BufferedReader in=new BufferedReader(
                   new InputStreamReader(soc.getInputStream()));
                String y= null;
                while((y = in.readLine()) != null){
               //         System.out.println(y);
                  output.setText(y);
                }
                }catch(Exception e1){}
            }
        }
    });       
 }
 }