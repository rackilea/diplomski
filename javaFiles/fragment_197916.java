public class MainActivity extends Activity {

public static String tab1_title;
public static String tab2_title;
public static String tab3_title;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Now you can use the tab1_title, tab2_title and tab3_title here
}