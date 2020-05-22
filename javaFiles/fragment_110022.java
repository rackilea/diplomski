final Dialog dialog = new Dialog(this);
dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
dialog.setContentView(R.layout.guideline);
dialog.setCanceledOnTouchOutside(true);
//for dismissing anywhere you touch
View masterView = dialog.findViewById(R.id.guidelineView);
masterView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        dialog.dismiss();
    }
});
dialog.show();