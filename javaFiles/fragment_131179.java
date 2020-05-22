public class deploy extends JFrame {

    private int seconds;
    private SimpleDateFormat df;
    private boolean isRunning;
    private JLabel lblTimer2;

    public deploy() {

        JPanel contentPane = new JPanel();
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        //better avoid null layout managers
        //contentPane.setLayout(null);
        contentPane.setLayout(new BorderLayout());

        lblTimer2 = new JLabel();
        lblTimer2.setForeground(Color.WHITE);
        lblTimer2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblTimer2.setPreferredSize(new Dimension(100,30));
        contentPane.add(lblTimer2,BorderLayout.NORTH);

        Timer tm2 = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setTimer();
                seconds++;
            }
        });

        JButton btnNewButton = new JButton("Start");
        btnNewButton.setBackground(Color.LIGHT_GRAY);
        btnNewButton.setForeground(Color.BLUE);
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(isRunning) {
                    tm2.stop();
                    btnNewButton.setText("Start");
                }else {
                    tm2.start();
                    btnNewButton.setText("Stop");
                }

                isRunning = !isRunning;
            }
        });
        //btnNewButton.setBounds(289, 257, 89, 32);
        btnNewButton.setPreferredSize(new Dimension(100,30));
        contentPane.add(btnNewButton, BorderLayout.SOUTH);

        //based on SANTOSHKUMAR SINGH answer
        df = new SimpleDateFormat("HH:mm:ss"); // HH for 0-23
        df.setTimeZone(TimeZone.getTimeZone("GMT"));

        seconds = 0;
        isRunning = false;
        setTimer();
        pack();
        setVisible(true);
    }


    private void setTimer() {

        //based on SANTOSHKUMAR SINGH answer
        Date d = new Date(seconds * 1000L);
        String time = df.format(d);
        lblTimer2.setText(time);
    }

    public static void main(String[] args) {
        new deploy();
    }
}