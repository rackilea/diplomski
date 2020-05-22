public TitleParentViewHolder onCreateParentViewHolder(ViewGroup viewGroup) {

View view = inflater.inflate(R.layout.list_routines, viewGroup, false);
ImageView playIcon = (ImageView) view.findViewById(R.id.playRoutine);
TextView rutNameView = (TextView) view.findViewById(R.id.parentTitle);
playIcon.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View v) {

        String rutName = rutNameView.getText().toString();
        Toast.makeText(v.getContext(), rutName + " was played",
                Toast.LENGTH_LONG).show();

    }
});
return new TitleParentViewHolder(view);
}