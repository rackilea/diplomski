Window window = yourDialog.getWindow();
if (window != null) {
  WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
  lp.copyFrom(window.getAttributes());
  //This makes the dialog take up the full width
  lp.width = WindowManager.LayoutParams.MATCH_PARENT;
  lp.height = WindowManager.LayoutParams.MATCH_PARENT;
  window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
  window.setAttributes(lp);
}