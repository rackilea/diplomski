if (core != null && core.needsPassword()) {
   if (core.authenticatePassword(mPassword)) {
      createUI(savedInstanceState);
   } else {
      requestPassword(savedInstanceState);
   }
   return;
}