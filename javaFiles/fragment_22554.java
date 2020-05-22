@Override
public void onStart() {
    super.onStart();
    Chartboost.onStart(this);
}

@Override
public void onResume() {
    super.onResume();
    Chartboost.onResume(this);
}

@Override
public void onPause() {
    super.onPause();
    Chartboost.onPause(this);
}

@Override
public void onStop() {
    super.onStop();
    Chartboost.onStop(this);
}

@Override
public void onDestroy() {
    super.onDestroy();
    Chartboost.onDestroy(this);
}

@Override
public void onBackPressed() {
    // If an interstitial is on screen, close it.
    if (Chartboost.onBackPressed()) {
        return;
    } else {
        super.onBackPressed();
    }
}