String Authkey= "";

if (VERSION.SDK_INT >= 26) {
       Authkey = Base64.getEncoder().encode(auth_.getBytes()).toString();
} else {
      Authkey = android.util.Base64.encodeToString(auth_.getBytes(), 0)
}