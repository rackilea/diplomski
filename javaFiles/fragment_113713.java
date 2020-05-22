public void startMoreDetailActivity(){
    Intent startintent = new Intent(context, Main_Page_Details.class);
    int position  = getAdapterPosition();
    startintent.putExtra("title",title_text);
    context.startActivity(startintent);
}