import java.awt.event.*;
import javax.swing.*;

public class Example extends Box{

    JLabel txtName = new JLabel("Nothing Entered");

    public temp(){
        super(BoxLayout.Y_AXIS);
        // Add FocusListener to first field
        final JTextField txtNo = new JTextField(20);
        txtNo.addFocusListener(new CustomFocusListener(txtNo));
        add(txtNo);

        // Add TextListener to first field
        final JTextField txtNo2 = new JTextField(20);
        txtNo2.addFocusListener(new CustomFocusListener(txtNo2));
        add(txtNo2);

        // Add TextListener to first field
        final JTextField txtNo3 = new JTextField(20);
        txtNo3.addFocusListener(new CustomFocusListener(txtNo3));
        add(txtNo3);

        add(new JButton("Do Something"));

        add(txtName);

    }


    public static void main(String[] args){
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Example());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Your custom focust listener that does all your SQL Work
     */
    public class CustomFocusListener extends FocusAdapter{
        JTextField field;

        public CustomFocusListener(JTextField field){
            this.field = field;
        }

        @Override
        public void focusLost(FocusEvent e) {
            //Assuming your database connection works, this gives you an example to follow
            txtName.setText(field.getText());
            /*Connection conn = null;
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");

                conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "Username", "Password");
                Statement st = conn.createStatement();
                String load = "Select * from Store_info_table where PART_NUMBER = '" + field.getText() + "'";
                ResultSet rs = st.executeQuery(load);
                while(rs.next()){
                   txtName.setText(rs.getString("SPARE_DESC"));
                }
            }catch(Exception ae){

            }*/
        }
    }
}