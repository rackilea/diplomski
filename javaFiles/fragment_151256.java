for (JInternalFrame jI : j) { // The first time j length == 0, so the loop is not executed
    if (jI.getName().equals(ss)) { // In this line, if jI.getName() == null, you'll get NPE
        b = true;
        break;
    } 
 }