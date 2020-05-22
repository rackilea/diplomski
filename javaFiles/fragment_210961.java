if(preferences.getBoolean("onboarding_complete",false)) {
    // Start Main Activity
    Intent intent = new Intent(this, MainActivity.class);
    startActivity(intent);

    // Close Onboarding
    finish();
    return;
}