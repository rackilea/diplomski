if (childDocument.length > 0) {
    for (int i = 0; i < childDocument.length; i++) {

        String doc = childDocument[i].replace("~", "");
        doc = doc.replace(",", "");

        image = new ImageView(mContext);
        image.setLayoutParams(new android.view.ViewGroup.LayoutParams(80, 60));
        image.setMaxHeight(50);
        image.setMaxWidth(50);

        Picasso.with(mContext)
                .load(imageDocument.trim() + doc)
                .error(R.drawable.doc_img)
                .into(image);

        viewHolder.linearLayout.addView(image);
        int lent = childDocument.length;
        Log.e("surajj", "docu " + imageDocument.trim() + doc + " position " + i + " lenth " + lent);
    }
} else {
    viewHolder.linearLayout.setVisibility(View.GONE);
}