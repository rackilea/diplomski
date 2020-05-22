if (preferences.getBooleanValue("is_logged")) {
            preferences
                    .addPreference("last_login", DateHelper.getCurrentDate());
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }