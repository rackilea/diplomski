@Override
public void onClick(View p1)
{
    if (x == 1)
    {
        textView.setText(R.string.step1);
        button.setText("Next");

        // heres increment of the variable x so on next click x will be 2 and the next if will be run instead
        x++;
    }
    if (x == 2)
    {
        textView.setText(R.string.step2);
        button.setText("Next");
    }
}