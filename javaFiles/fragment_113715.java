public void startMoreDetailActivity(){
    Intent startintent = new Intent(context, Main_Page_Details.class);
    title_text = mSnaps.get(getAdapterPosition()).getText();
    startintent.putExtra("title",title_text);
    context.startActivity(startintent);
}