public static class TextViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
      public TextView newsTitle, newsExcerpt;
      public ImageButton imageButton;
      public NewsItems dNewsItems;
      private Context context;

      public TextViewHolder (final View newsView, final Context context) {
          super(newsView);
          this.context = context;   // EDIT 1: You are missing this
          newsTitle = (TextView) newsView.findViewById(R.id.news_title);
          newsExcerpt = (TextView) newsView.findViewById(R.id.news_excerpt);
          newsExcerpt.setOnClickListener(this);
      }