case R.id.btnPauseRide:
        mLoggerServiceManager.pauseGPSLogging();

        setResult( RESULT_OK, intent );
        btnPPauseRide.setVisibility(View.GONE);
        btnResume.setVisibility(View.VISIBLE);
        break;