if (!allowNavigation) {
     jTabbedPane1.setEnabledAt(0, true);
    allowNavigation = true;
 }
else if (allowNavigation) {
    jTabbedPane1.setEnabledAt(0, false);
    allowNavigation = false;
 }