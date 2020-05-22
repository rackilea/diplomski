// some code blocks

@Override
public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
    final Model object = dataset.get(position);

    if (Build.VERSION.SDK_INT >= 24) {
        // ( (ImageTypeViewHolder) holder).subtitle.setText(Html.fromHtml(object.subtitle , Html.FROM_HTML_MODE_LEGACY));
        ((ImageTypeViewHolder) holder).title.setText(Html.fromHtml(object.title , Html.FROM_HTML_MODE_LEGACY));
        ((ImageTypeViewHolder) holder).date.setText(Html.fromHtml(object.date , Html.FROM_HTML_MODE_LEGACY));
    } else {
        // ((ImageTypeViewHolder) holder).subtitle.setText(Html.fromHtml(object.subtitle));
        ((ImageTypeViewHolder) holder).title.setText(Html.fromHtml(object.title));
        ((ImageTypeViewHolder) holder).date.setText(Html.fromHtml(object.date));
    }


    ((ImageTypeViewHolder) holder).imageView.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           Intent intent = new Intent(mContext, WPPostDetails.class);
           intent.putExtra("itemPosition", position);
           mContext.startActivity(intent);
       }
    });

    JsonApiGlideUrl url = new JsonApiGlideUrl(object.Image);
    GlideApp.with(imageView.getContext())
         .load(url)
         .into(imageView);
}

// some code blocks