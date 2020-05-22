public class VegasAdapter extends ArrayAdapter<Vagas> {
    public VegasAdapter(Context context, ArrayList<Vagas> users) {
       super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       // Get the data item for this position
       Vagas vagas = getItem(position);    
       // Check if an existing view is being reused, otherwise inflate the view
       if (convertView == null) {
          convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_, parent, false);
       }
       // Lookup view for data population
       TextView tv1 = (TextView) convertView.findViewById(R.id.funcao);
       TextView tv1 = (TextView) convertView.findViewById(R.id.descricao);

// get data and binding with textview
// Below lines are just sample based on you class if you need full code post your Vagas.java code
       tvName.setText(vagas.getFincao());
       tvHome.setText(vagas.getDescripcao());


       // Return the completed view to render on screen
       return convertView;
   }
}