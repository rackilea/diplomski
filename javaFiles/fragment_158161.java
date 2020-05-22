@Override
protected String doInBackground(String... params) {
    try {
        doc = Jsoup.connect(url).get();
        Log.e("Jsoup", "...is working...");
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        Log.e("Exception", e.getMessage());
    }

    content = doc.select("#content");
    parse = Jsoup.parse(doc.html());
    results = doc.select("#content").outerHtml();

    // find rating image...
    dangerRatingImg = doc.select("img").first();
    dangerRatingSrc = dangerRatingImg.absUrl("src");
    // Get the rating image
    bimage = getBitmapFromURL(dangerRatingSrc);

    return results;
}

@Override
protected void onPostExecute(String result) {
    // smooth out the long scrolling...
    textView.setMovementMethod(ScrollingMovementMethod.getInstance());
    // Set the rating image
    image.setImageBitmap(bimage);
    image.setPadding(10, 10, 10, 10);
    image.setScaleType(ScaleType.FIT_XY);

    // return the summary
    results = parse.select("#reportSummary").outerHtml();
    textView.setText(Html.fromHtml(results));
    textView.setPadding(10, 10, 10, 10);
    // ditch the dialog, it's all loaded.
    dialog.dismiss();
}