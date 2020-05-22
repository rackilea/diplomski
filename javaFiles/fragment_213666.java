@override 
public void onClick(View v) {
    if(clickTrack[position] == 0) clickTrack[position] = 1;
    else clickTrack[position] = 0;

    notifyDataSetChanged();
}