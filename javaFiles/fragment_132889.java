import { NativeModules } from 'react-native'


export const getPairedDevices = (callback) => {
  NativeModules.PrintUtils.getPairedDevices(callback);
}

export const printText = (text,size,align,mac_address,returnCallback) => {
  NativeModules.PrintUtils.printText(text,size,align,mac_address,returnCallback);
}

export const ALIGN_LEFT=NativeModules.PrintUtils.ALIGN_LEFT;