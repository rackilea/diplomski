@Override
public void onAuthSuccess(FingerprintManager.CryptoObject cryptoObject) {
    texto = "Sucesso";
    textFinger.setText(texto); //Change to this
    presenter.sendData(bundle.getString(USER), bundle.getString(PASS));
    FragmentUtils.navigateTo(getActivity(), TermsOfUseFragment.TAG, new TermsOfUseFragment(), R.id.fragmentContainer);
}