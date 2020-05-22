@Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
  public void onBuyPremium(final BuyPremiumUserEvent event) {
  clickedOnBuyPremium = event.isClickOnBuyPremium();
  initBazaarUserRegistered();
  Log.e("paymentLog", "Clicked");
}