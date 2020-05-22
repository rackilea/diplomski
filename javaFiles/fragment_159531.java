media = doc.select("img[src]");

for (Element src : media) {
   Toast.makeText(ImagetestActivity.this, src.attr("src"),
                Toast.LENGTH_LONG).show();
}