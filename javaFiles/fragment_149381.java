@Override
public void onClick(View v) {
    ...
    if (v instanceof Button) {
        ((Button) v).setBackgroundColor(Color.WHITE);
        ((Button) v).setTextColor(Color.BLACK);
    }
}