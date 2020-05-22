public class MainActivity extends AppCompatActivity {
    AbstractXMPPConnection conn1 = new XMPPTCPConnection("username", "password" ,"jabber.org");

     public void connectToSomething()   ... some exceptions here must be thrown{

          conn1.connect();
    }    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}