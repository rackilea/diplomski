// hard coding songs.get(0) could lead to issues as well but at least fix the index i
for (int i = 0; i < songs.get(0).size(); i++)
{
    TextView textView = new TextView(this);
    ...
    //Error is thrown here
    textView.setText(songs.get(0).getVerses().get(i);
    ...
 }