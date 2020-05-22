if (allowNavigation == false) {
         jTabbedPane1.setEnabledAt(0, true);
        allowNavigation = true;
     }
    else if (allowNavigation == true) {
        jTabbedPane1.setEnabledAt(0, false);
        allowNavigation = false;
     }