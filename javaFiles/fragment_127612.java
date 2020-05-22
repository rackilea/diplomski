messageToMainService.what = VALUES_FROM_THREAD;
messageData.putParcelable("pgnParcelable", pgnListParcelable);
messageData.putParcelable("currentLocation", myLocation);
messageData.putLong("timerBoucle", ellapseTime + timeToSleep);
    //messageData.putWhateverYouWant
messageToMainService.setData(messageData);
mHandler.dispatchMessage(messageToMainService);