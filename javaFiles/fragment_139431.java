public class TestActivity extends AppCompatActivity implements View.OnClickListener {
    .....
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ....
        for (int i = 0; i < letterBttns.length; i++) {
            letterBttns[i].setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        String text = ((Button) v).getText().toString();
    }
}