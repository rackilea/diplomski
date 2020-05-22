@Subscribe(threadMode = ThreadMode.MAIN)
  function onLowGasEvent(){
     mGasImpl.onLowGasEvent();
  }

  @Subscribe(threadMode = ThreadMode.MAIN)
  function onLowBatteryEvent(){
    mBatteryImpl.onLowBatteryEvent();
  }