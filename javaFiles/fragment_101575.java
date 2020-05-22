@Override
    protected Void doInBackground(Article... articles) {
        Article item = (Article) getArguments().getSerializable("Article");
         if(item!=null){
            mArticleList.add(item);
        }
        return null;
    }