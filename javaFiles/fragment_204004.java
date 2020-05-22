function callItNow() {
  if (typeof Android != "undefined"){ 
    if (Android.caller!= "undefined") {
      Android.caller();
    }
  }
}