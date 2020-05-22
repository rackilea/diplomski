new AsyncTask<Object, Object, Object>() { // Specify proper arguments
            protected Object doInBackground(final Object... params) {
                String token;
                try {
                    token = gcm.register(getString(R.string.project_number));
                    Log.i("registrationId", token);
                } catch (IOException e) {
                    Log.i("Registration Error", "mesgerror " + e.getMessage());
                }
                return true;
            }
        }.execute(null, null, null);