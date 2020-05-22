@Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View selfieImage = convertView;
            final ViewHolder holder;
            if (selfieImage == null) {
                LayoutInflater inflater = (LayoutInflater) parent
                        .getContext().getSystemService(
                                Context.LAYOUT_INFLATER_SERVICE);
                selfieImage = inflater.inflate(R.layout.widget_sample_item,
                        parent, false);
                holder = new ViewHolder(selfieImage);

                selfieImage.setTag(holder);

            } else {
                holder = (ViewHolder) selfieImage.getTag();
            }

            holder.timestamp.setText("this is: " + position + "th child");

            selfieImage.measure(MeasureSpec.UNSPECIFIED,MeasureSpec.UNSPECIFIED);

            int height = holder.selfieImage.getMeasuredHeight();
            int width = holder.selfieImage.getMeasuredWidth();
            Log.d("image-info", width + " | " + height);

            return selfieImage;
        }