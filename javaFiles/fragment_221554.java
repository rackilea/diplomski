public class Frame extends JFrame{

    private static final long serialVersionUID = -5151041547543472432L; //ignore this it is just the serial id of the JFrame you can omit this line from your code

    ComponentsStorage cs = new ComponentsStorage(); //display class as variable so we can use it more efficnent 

    public Frame(){
        launch(); //execute function
    }

    public void launch() { //launch
        setTitle("Frame Demo");//title
        setSize(640, 480);//size (width * height)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close when close button is pressed

        //you can just do ComponentStorage.tf.blah blah blah... but it is much easier as a variable
        cs.label.setSize(500, 500); // you can mess up witht the components you stored there
        cs.tf.setSize(40, 5); //as you can see here I am just adding the components by 

        //add them here
        add(cs.label);
        add(cs.tf);

        setLocationRelativeTo(null);//by setting this you place the screen always in the middle of the screen
        setVisible(true);//there is no point of creating JFrames if they aren't visible
    }

}