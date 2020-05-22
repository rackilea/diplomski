FirebaseAnalytics mFirebaseAnalytics;
        mFirebaseAnalytics=FirebaseAnalytics.getInstance(this);

        FirebaseDynamicLinks.getInstance()
        .getDynamicLink(getIntent())
        .addOnSuccessListener(this, new 
         OnSuccessListener<PendingDynamicLinkData>() {
            @Override
            public void onSuccess(PendingDynamicLinkData pendingDynamicLinkData) {
                // Get deep link from result (may be null if no link is found)
                Uri deepLink = null;

                if (pendingDynamicLinkData != null) {
                    deepLink = pendingDynamicLinkData.getLink();

                    Log.w("deepLink", "" + deepLink);
               String cn=String.valueOf(deepLink.getQueryParameters("utm_campaign"));
                    String cm = String.valueOf(deepLink. getQueryParameters("utm_medium"));
                    String cs = String.valueOf(deepLink.getQueryParameters("utm_source"));

                    if (cs != null && cn != null) {
                        Bundle params = new Bundle();
                        params.putString(FirebaseAnalytics.Param.CAMPAIGN, cn);
                        params.putString(FirebaseAnalytics.Param.MEDIUM, cm);
                        params.putString(FirebaseAnalytics.Param.SOURCE, cs);

                        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.CAMPAIGN_DETAILS, params);
                        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.APP_OPEN, params);
                    }


                }
            }
        })
        .addOnFailureListener(this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w("TAG", "getDynamicLink:onFailure", e);
            }
        });