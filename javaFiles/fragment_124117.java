String txtLink = "<p>Apply directly in our <a href=\"https://theorem.applytojob.com/apply/TyJy6YCsOs/Experienced-Backend-Engineer-Ruby?source=GitHub+Jobs\">careers page</a></p>";

TextView txtJobLink = findViewById(R.id.txtJobLink);
txtJobLink.setMovementMethod(LinkMovementMethod.getInstance());

if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
    txtJobLink.setText(Html.fromHtml(txtLink, Html.FROM_HTML_MODE_LEGACY));
} else {
    txtJobLink.setText(Html.fromHtml(txtLink));
}