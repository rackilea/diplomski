public View anEpisode(String n, String i, String d){
    View v;
    LayoutInflater inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    v = inflater.inflate(R.layout.episodedescription, null);

    TextView nameOfEpisode = (TextView) v.findViewById(R.id.episodedescriptionname);
    ImageView imageOfEpisode = (ImageView) v.findViewById(R.id.episodedescriptionimage);
    TextView descriptionOfEpisode = (TextView) v.findViewById(R.id.episodedescriptiondescription);

    nameOfEpisode.setText(n);
    descriptionOfEpisode.setText(d);
    createUrlImage(imageOfEpisode, i);

    return v;
}


flipper.addView(anEpisode("test", "url image", "test description"));