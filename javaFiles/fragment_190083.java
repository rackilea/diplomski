LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

   RelativeLayout view = (RelativeLayout)inflater.inflate(R.layout.custom_dialog, null, false);

   TextView rn = (TextView) view.findViewById(R.id.tvRName);

   dialog.setContentView(view);