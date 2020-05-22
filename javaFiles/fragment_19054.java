@Override
public View getView(int position, View convertView, ViewGroup parent) {
    Data hospital = (Data)datas.get(position);

    if(convertView == null){

         convertView = LayoutInflater.from(context).inflate(R.layout.fragment_hospitals,parent,false);
        //convertView = LayoutInflater.inflate(R.layout.fragment_hospitals,parent,false);
    }

    TextView chakula = (TextView)convertView.findViewById(R.id.hospitals_name);
    ImageView pilau = (ImageView)convertView.findViewById(R.id.hospitals_image);

    chakula.setText(hospital.getName());

    Glide
            .with(context)
            .load(hospital.url_image)
            .centerCrop()
            .crossFade()
            .into(pilau);

    return convertView;
}