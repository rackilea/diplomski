@Override
public View getView(int position, View convertView, ViewGroup parent) {

    ViewHolder holder;
    if(convertView == null) {
        convertView = vi.inflate(Resourse, null);
        holder = new ViewHolder();

        holder.imageview = (ImageView) convertView.findViewById(R.id.imagenews);
        holder.nameNews = (TextView) convertView.findViewById(R.id.namenews);
        holder.dayNews = (TextView) convertView.findViewById(R.id.daynews);

        convertView.setTag(holder);
    } else {
        holder = (ViewHolder) convertView.getTag();
    }

    // I am not sure about return value of ArrayListNews.get(position).getImageNews(); 
    // It should be URL pointing to your image file
    Picasso.with(context).load(ArrayListNews.get(position).getImageNews()).into(holder.imageview);

    holder.nameNews.setText(ArrayListNews.get(position).getNameNews());
    holder.dayNews.setText(ArrayListNews.get(position).getDayNews());

    return convertView;
}