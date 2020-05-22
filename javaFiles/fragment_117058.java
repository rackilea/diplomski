public void onButtonClick(View view) {
        Intent intent;
        switch (view.getId()) {
        case R.id.alpha_button:
            intent = new Intent(this, AlphaActivity.class);
            break;
        case R.id.beta_button:
            intent = new Intent(this, BetaActivity.class);
            break;
        default:
            return;
        }
        startActivity(intent);
    }