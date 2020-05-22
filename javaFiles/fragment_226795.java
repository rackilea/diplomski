private class ImageLoader extends AsyncTask<NewsAndImages, Void, NewsAndImages> {
    @Override
    protected NewsAndImages doInBackground(NewsAndImages... params) {
        NewsAndImages container = params[0];
        News news = container.news;
        try {
            if (container.position > 0) {
                InputStream in = (InputStream) new URL(news.getImage150()).getContent();
                Bitmap bitmap = BitmapFactory.decodeStream(in);
                news.setBitmap(bitmap);
                in.close();
                container.bitmap = bitmap;
                return container;
            } else {
                InputStream in = (InputStream) new URL(news.getRealImage()).getContent();
                Bitmap bitmap = BitmapFactory.decodeStream(in);
                news.setBitmap(bitmap);
                in.close();
                container.bitmap = bitmap;
                return container;
            }
        } catch (Exception e) {
            Log.v("LOGTAG", e + " streaming pic" + news.getImage150());
        }
        return null;
    }

    @Override
    protected void onPostExecute(NewsAndImages newsAndImages) {
        try {
            if (newsAndImages.position > 0) {
                ImageView imageView = (ImageView) newsAndImages.view.findViewById(R.id.newsListImage);
                imageView.setImageBitmap(newsAndImages.bitmap);               
                imageCache.put(newsAndImages.news.getNews_id(),newsAndImages.bitmap);
            } else {
                ImageView imageView = (ImageView) newsAndImages.view.findViewById(R.id.newsHeadLineImage);
                imageView.setImageBitmap(newsAndImages.bitmap);
                imageCache.put(newsAndImages.news.getNews_id(),newsAndImages.bitmap);
            }
        } catch (Exception e) {
            Log.i(NewsDBOpenHelper.LOGTAG, e + " onPostExecute");
        }
    }
}