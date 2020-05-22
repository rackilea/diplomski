View view = convertView;
if (view == null){
        LayoutInflater li = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = li.inflate(R.layout.place_respuesta, null);
 }

        TextView  mTVItem = (TextView) view.findViewById(R.id.placeRespuesta);
        mTVItem.setText(respuestas.get(position).getRespuesta());

return view;