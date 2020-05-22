@Override
public View getView(final int position, View convertView, ViewGroup parent) {

    Button buttonAnswerAdapter = null;

    if (convertView == null) {
        buttonAnswerAdapter = new Button(context);
        buttonAnswerAdapter.setLayoutParams(new GridView.LayoutParams(100, 100));
        buttonAnswerAdapter.setPadding(8, 8, 8, 8);
        buttonAnswerAdapter.setBackgroundColor(Color.BLUE);
        buttonAnswerAdapter.setTextColor(Color.GREEN);
        buttonAnswerAdapter.setText(answer.get(position));
    }else{
        buttonAnswerAdapter = (Button) convertView;
    }

    if(newList.size() != 0){
        if (newList.get(position).equals(answer.get(position))) {
            buttonAnswerAdapter.setBackgroundColor(Color.BLACK);
            buttonAnswerAdapter.setTextColor(Color.RED);
        }
    }

    return buttonAnswerAdapter;
}