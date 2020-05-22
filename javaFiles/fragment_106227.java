class SettingsForm extends JFrame{

    JButton submit,defaultOption;//koumpia kataxwrhshs-akurwshs
    JLabel host, port, dbName, user, pass;//koina JLabel.Etiketes host, port, dbName, user kai password
    JTextField hostT, portT, dbNameT, userT, passT;//koina JTextField.perioxh egrafhs twn host, port, dbName, user kai password
    ImageIcon img;

    public SettingsForm()//arxikh dhmiourgia tou frame
    {
        super("Data Base Information");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.img = new ImageIcon("logo.png");
        this.setIconImage(this.img.getImage());
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }//constractor

    public void createForm(int rows,int columns,int vgap,int hgap)//orizei sto panel tou frame topothethsh sumfwna me to GridLayout
    {
        JPanel panel=new JPanel();
        GridLayout g=new GridLayout(rows,columns,vgap,hgap);
        panel.setLayout(g);
        this.setContentPane(panel);

        this.addElements();

        submit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (hostT.getText().length()!=0 && portT.getText().length()!=0 && dbNameT.getText().length()!=0 && userT.getText().length()!=0 && passT.getText().length()!=0)
                {
                    try {
                    CreateSettings s = new CreateSettings("Endocrino\\settings.txt");
                    s.write(hostT.getText(), portT.getText(), dbNameT.getText(), userT.getText(), passT.getText());
                    close();
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    } catch (Exception e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"All items must be filled","Warning",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        defaultOption.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {   hostT.setText("localhost");
                portT.setText("3306");
                dbNameT.setText("endocrino");
                userT.setText("endo");
                passT.setText("1234");
            }
        });
    }//createForm


    public void addButtons()//prosthetei to koumpi kataxwrhshs sto panel
    {
        Container c=this.getContentPane();
        this.submit=new JButton("OK");
        this.defaultOption=new JButton("Set Default");

        c.add(submit);
        c.add(defaultOption);
    }//addButtons

    public void addHost()//prosthetei to label kai text field gia egrafh tou host apo ton xrhsth
    {
        Container c=this.getContentPane();
        this.host=new JLabel("Host");
        this.hostT=new JTextField();
        c.add(host);
        c.add(hostT);
    }//addHost

    public void addPort()//prosthetei to label kai text field gia egrafh tou port apo ton xrhsth
    {
        Container c=this.getContentPane();
        this.port=new JLabel("Port");
        this.portT=new JTextField();
        c.add(port);
        c.add(portT);
    }//addPort

    public void addDBName()//prosthetei to label kai text field gia egrafh tou Data Base Name apo ton xrhsth
    {
        Container c=this.getContentPane();
        this.dbName=new JLabel("Data Base Name");
        this.dbNameT=new JTextField();
        c.add(dbName);
        c.add(dbNameT);
    }//addDBName

    public void addUser()//prosthetei to label kai text field gia egrafh tou user apo ton xrhsth
    {
        Container c=this.getContentPane();
        this.user=new JLabel("User");
        this.userT=new JTextField();
        c.add(user);
        c.add(userT);
    }//addUser

    public void addPassword()//prosthetei to label kai text field gia egrafh tou password apo ton xrhsth
    {
        Container c=this.getContentPane();
        this.pass=new JLabel("Password");
        this.passT=new JTextField();
        c.add(pass);
        c.add(passT);
    }//addPassword

    public void addElements(){
        this.addHost();
        this.addPort();
        this.addDBName();
        this.addUser();
        this.addPassword();
        this.addButtons();
    }//addElements

    public void close() throws InterruptedException{
        this.dispose();
        DosCommandsWindow d=new DosCommandsWindow();
        d.createForm(7,1,3,3);
    }//close