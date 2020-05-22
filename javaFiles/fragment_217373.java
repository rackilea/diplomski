public View getView(int position, View view, ViewGroup parent) {
        if(view == null){
            LayoutInflater inflater = context.getLayoutInflater();
            view= inflater.inflate(R.layout.list_single, null, true);
         }
            TextView txtTitle = (TextView) view.findViewById(R.id.txt);

            ImageView imageView = (ImageView) view.findViewById(R.id.img);
            txtTitle.setText(web[position]);

            imageView.setImageResource(imageId[position]);
            return view;
        }