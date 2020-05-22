if (ss.error != null) {
        final CharSequence error = ss.error;
        // Display the error later, after the first layout pass
        post(new Runnable() {
            public void run() {
                setError(error);
            }
        });