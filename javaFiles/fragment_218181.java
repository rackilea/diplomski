Context context;
private WeatherDBHelper weatherDBHelper;
public QueryUtils(Context context){
     this.context = context;
     weatherDBHelper = new WeatherDBHelper(context); 
}