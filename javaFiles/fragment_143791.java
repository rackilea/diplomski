public class MyActivity extends Activity implements OnClickListener {

    public onCreate() {
        String[] strings = getResources().getStringArray(R.array.buttonStrings);

        for(int i=0;i<strings.length;++i) {
            createButton(strings[i]);
        }
    }

    private Button createButton(String s) {
        Button b = new Button(this);
        b.setText(s);
        b.setTextSize(BUTTON_TEXT_SIZE);
        b.setHeight(BUTTON_HEIGHT);
        b.setWidth(BUTTON_WIDTH);
        b.setOnClickListener(this);
        return b;
    }

    @Override
    public onClickListener(View v) {
        tvButtons.append(((Button)v).getText().toString());
    }
}