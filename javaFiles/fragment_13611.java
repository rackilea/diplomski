class HybridCar extends Car implements IGas {
  IGas mGasImpl;
  IBattery mBatteryImpl;   

  checkGas() {
    mGasImpl.checkGas();
  }
  checkBattery() {
    mBatteryImpl.checkBattery();
  }
}