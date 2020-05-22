@Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(getContext());

        View customView = layoutInflater.inflate(R.layout.my_row, parent, false);

        ViewHolder holder = new ViewHolder();

        holder.name = (TextView)customView.findViewById(R.id.nameTextView);
        holder.picture = (ImageView)customView.findViewById(R.id.pictureImageView);

        holder.name.setText(allNames.get(position));
        holder.picture.setImageResource(allPictures.get(position));

        //This does not work ---> holder.name.setTag(counter);

        customView.setTag(Integer.valueOf(counter));

        counter ++;
        return customView;
    }