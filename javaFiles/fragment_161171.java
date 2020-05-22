public static void openUrl( String url ){
        Log.v(TAG, "PTServicesBridge  -- Open URL " + url);

        PTServicesBridge.urlString = url;

        Bundle params = new Bundle();
        params.putString("levelname", url);

        // Get FirebaseAnalytics Object
        FirebaseAnalytics mFirebaseAnalytics = FirebaseAnalytics.getInstance(PTServicesBridge.activity);
        mFirebaseAnalytics.logEvent("levels", params); //Problematic line it gives error.
}