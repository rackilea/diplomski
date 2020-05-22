class GasCar extends Car implements IGas {
  IGas mGasImpl = new GasImpl();   // create it in your own code, or inject to inverse dependencies, etc.

  checkGas() {
    mGasImpl.checkGas();
  }

  onLowGasEvent() {
    mGasImpl.onLowGasEvent();
  }
}

class BatteryCar extends Car implements IBattery {
  IBattery mBatteryImpl;   

  checkBattery() {
    mBatteryImpl.checkGas();
  }

  onLowBatteryEvent() {
    mBatteryImpl.onLowBatteryEvent();
  }
}