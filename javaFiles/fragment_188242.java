ImageButton[] buttons = new ImageButton[<put here the total number of Buttons>];

buttons[0] = (ImageButton)findViewById(R.id.butid1);
buttons[1] = (ImageButton)findViewById(R.id.butid2);
...
buttons[N-1] = (ImageButton)findViewById(R.id.butidN);

for (int i = 0; i < N; i++) {
    buttons[i].setEnabled(false);
}