public void setDetails(Context ctx,String date, String time, String score)
{
    TextView mdate=mView.findViewById(R.id.date_box);
    TextView mtime=mView.findViewById(R.id.time_box);
    TextView mscore=mView.findViewById(R.id.score_box);
    mdate.setText(date);
    mtime.setText(time);
    mscore.setText(score);
}