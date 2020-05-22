public class MyActivity extends AppCompatActivity {

@Inject
MyView myView;

@Override
public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(myView.getRootView());
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    myView.displayMenu();
    return super.onCreateOptionsMenu(menu);
}

}

public class MyViewImpl implements MyView {

    @Override
    public void displayMenu() {
        activity.getMenuInflater().inflate(
            R.menu.categories_modification_menu,
            rootView.findViewById(R.id.toolbar).getMenu()
        )
    }

}