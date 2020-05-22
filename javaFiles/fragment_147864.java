public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    PageBuilder obj = new PageBuilder(this);
    obj.mainMenu();
}}