private void loadURI()
  {
      PreferenceManager.setDefaultValues(this, R.xml.settings, true);
      SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
      if (settings.getBoolean("default_uri", false)){
            String defaultURI = getString(R.string.dream_uri);
            this.mWebView.loadUrl(defaultURI);
      }
      else {
          String customURI = settings.getString("custom_uri", "");
          this.mWebView.loadUrl(customURI);
      }

  }