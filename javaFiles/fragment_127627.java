void usbConnectionStateChange(int state) {
   if (state == USB_STATE_CABLE_CONNECTED) {
      // start playing your sound
   } else if (state == USB_STATE_CABLE_DISCONNECTED) {
      // stop playing your sound, and exit, or just stay in the background
   }
}