DbTools dbTools;
public Adapter(Context context,ArrayList<NameAddress> rslt){
    result = rslt; //this line is swapped
    this.context=context;
    dbTools = new DbTools(context);
    inflater =  (LayoutInflater)(this.context).getSystemService(Context.LAYOUT_INFLATER_SERVICE);
}