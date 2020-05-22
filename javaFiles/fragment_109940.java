Intent previousIntent = getIntent();
    if (previousIntent.getExtras() != null) {
        Bundle previousExtras = previousIntent.getExtras();
        if (previousExtras != null) {
            // Retrieve:
            if (previousExtras.containsKey(THISIDMODEL)) {
                // Re-instanciate new user.
                IdModelDTO test = previousExtras.getParcelable(THISIDMODEL);
                Log.d(TAG, " Previous Details:" + test.toString());
            }
        }
    }