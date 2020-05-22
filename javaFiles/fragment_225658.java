@Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mHolder;

        try{


        if (convertView == null) {
            mHolder = new ViewHolder();
            LayoutInflater vi = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.prueba, null);
            mHolder.nombre = (TextView) convertView.findViewById(R.id.txtNombre);
            mHolder.edad = (TextView) convertView.findViewById(R.id.txtEdad);

            convertView.setTag(mHolder);
        }else{
            mHolder = (ViewHolder) convertView.getTag();
        }

            mHolder.edad.setText(data.get(position).name);
            mHolder.nombre.setText(data.get(position).name);

        } catch (Exception e) {
            message = e.getMessage();
            Toast.makeText(getBaseContext(), message, Toast.LENGTH_LONG).show();
        }
        return convertView;
    }

class ViewHolder {
    TextView nombre;
    TextView edad;
}