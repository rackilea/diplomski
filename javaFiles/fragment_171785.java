String well ="";
Bundle bun = getIntent().getExtras();
String standard = "yes";
if(bun != null){
    well = bun.getString("WELL");
    if(well == null) well = "";
    if(well == standard) buttonLogin(context);
}