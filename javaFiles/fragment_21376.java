public class MyActivity extends Activity implements CompoundButton.OnCheckedChangeListener {
    Switch[] buttons;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        buttons = new Switch[5];
        Switch switchButtonOne = findViewById(R.id.switchButtonOne);
        switchButtonOne.setOnCheckedChangeListener(this);
        switchButtonOne.setChecked(sharedPreferences[0].getBoolean("1", false));
        buttons[0] = switchButtonOne;

        Switch switchButtonTwo = findViewById(R.id.switchButtonTwo);
        switchButtonTwo.setOnCheckedChangeListener(this);
        switchButtonTwo.setChecked(sharedPreferences[1].getBoolean("2", false));
        buttons[1] = switchButtonTwo;

        //...... (In total there are 5 switch buttons)
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int index;
        switch (buttonView.getId()) {
            case R.id.switchButtonOne:
                index = 0;
                break;
            case R.id.switchButtonTwo:
                index = 1;
                break;
                ...
        }
        if (isChecked) {
            stringArrayList.add(String.valueOf(index + 1));
        } else {
            stringArrayList.remove(String.valueOf(index + 1));
        }
        getArray(stringArrayList);
        //SAVE
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences[index].edit();
        editor.putBoolean(String.valueOf(index + 1), buttons[index].isChecked());
        editor.commit();
    }
}