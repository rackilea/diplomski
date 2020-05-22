class ForTheLulz extends AsyncTask<Void, Void, Bitmap> {
        @Override
        protected Bitmap doInBackground(Void... args) {
            Bitmap result = null;
            try {
                Document doc = Jsoup.connect("http://lulpix.com")
                        .referrer("http://www.google.com")
                        .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                        .get();
                        //parse("http://lulpix.com");
                if (doc != null) {
                    Elements elems = doc.getElementsByAttributeValue("class", "pic rounded-8");
                    if (elems != null && !elems.isEmpty()) {
                        Element elem = elems.first();
                        elems = elem.getElementsByTag("img");
                        if (elems != null && !elems.isEmpty()) {
                            elem = elems.first();
                            String src = elem.attr("src");
                            if (src != null) {
                                    URL url = new URL(src);
                                    // Just assuming that "src" isn't a relative URL is probably stupid.
                                    InputStream is = url.openStream();
                                    try {
                                        result = BitmapFactory.decodeStream(is);
                                    } finally {
                                        is.close();
                                    }
                            }
                        }
                    }
                }
            } catch (IOException e) {
                // Error handling goes here
            }
            return result;
        }
        @Override
        protected void onPostExecute(Bitmap result) {
            ImageView lulz = (ImageView) findViewById(R.id.lulpix);
            if (result != null) {
                lulz.setImageBitmap(result);
            } else {
                //Your fallback drawable resource goes here
                //lulz.setImageResource(R.drawable.nolulzwherehad);
            }
        }
    }