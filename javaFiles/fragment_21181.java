private LayoutInflater inflater;

public customAdapter (Context context,List<Information>data){
    inflater=LayoutInflater.from(context);
    this.data= data;
}