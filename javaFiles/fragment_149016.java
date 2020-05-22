public class SecondActivity extends Activity {
    Button             saveBtn, cancelBtn, addBtn;
    RelativeLayout     layout;
    EditText           third, first, second;
    LinearLayout       Container;
    int                counter = 0;
    int                all     = 0;
    int                tag     = 0;
    ArrayList<Integer> dynamicLayoutsTags;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        saveBtn = (Button) findViewById(R.id.save);
        cancelBtn = (Button) findViewById(R.id.cancel);
        Container = (LinearLayout) findViewById(R.id.container);
        addBtn = (Button) findViewById(R.id.addBtn);
        saveBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (dynamicLayoutsTags.size() > 0) {

                    for (int i = 0; i < dynamicLayoutsTags.size(); i++) {
                        View getView = Container
                                .findViewWithTag(dynamicLayoutsTags.get(i));
                        EditText editText1 = (EditText) getView
                                .findViewById(R.id.editText1);
                        EditText editText2 = (EditText) getView
                                .findViewById(R.id.editText2);
                        EditText editText3 = (EditText) getView
                                .findViewById(R.id.editText3);
                        Toast.makeText(
                                SecondActivity.this,
                                "Row " + i + " : " + "editext 1 is : "
                                        + editText1.getText()
                                        + " editext 2 is : "
                                        + editText2.getText()
                                        + " editext 3 is : "
                                        + editText3.getText(),
                                Toast.LENGTH_LONG).show();

                    }

                }

                Intent intent = new Intent(SecondActivity.this,
                        MainActivity.class);
                startActivity(intent);
                Toast.makeText(SecondActivity.this, "The Result: " + all,
                        Toast.LENGTH_LONG).show();
                finish();

            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this,
                        MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        addBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = (LayoutInflater) getBaseContext()
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View addView = layoutInflater.inflate(R.layout.row, null);
                Button buttonRemove = (Button) addView
                        .findViewById(R.id.remove);
                addView.setTag(tag);
                buttonRemove.setTag(tag);
                dynamicLayoutsTags.add(tag);
                Container.addView(addView);
                tag++;
                buttonRemove.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // ((LinearLayout) addView.getParent())
                        // .removeView(addView);
                        Integer removeTag = (Integer) v.getTag();
                        View deleteView = Container.findViewWithTag(removeTag);
                        Container.removeView(deleteView);
                        dynamicLayoutsTags.remove(removeTag);
                    }
                });

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        tag = 0;
        dynamicLayoutsTags = new ArrayList<Integer>();
    }

}