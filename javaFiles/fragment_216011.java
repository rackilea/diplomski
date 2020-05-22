String link = "";
//...
switch (v.getId()) {
    case R.id.atlanta:
        menu.setHeaderTitle("Atalanta");
        link = "https://whateveryouwant.com"
        inflater.inflate(R.menu.context_menu,menu);
        break;
    //do this with every case
}
//...
Intent i = new Intent(Intent.ACTION_VIEW);
i.setData(Uri.parse(link));
startActivity(i);