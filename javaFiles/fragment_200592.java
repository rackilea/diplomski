@Override
public void onClick(View view) {
    switch (view.getId()) {
        case R.id.button4:
                myInt = myRand.nextInt(10);
                textView2.setText(quiz[myInt][ques]);
                textView3.setText(quiz[myInt][ans]);
            break;
}