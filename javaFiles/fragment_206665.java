public static void setSubComponentFont (Component comp[], Font font) {
    for (int x = 0; x < comp.length; x++) {
        if (comp[x] instanceof Container) {
            setSubComponentFont(((Container)comp[x]).getComponents(), font);
        }  
        try {
            //comp[x].setFont(font);
            if (comp[x].toString().contains("JMenu")) {
                for (Component y : ((JMenu)comp[x]).getPopupMenu().getComponents()) {
                    if (y.toString().contains("JMenu")) {
                        y.setFont(font);
                    }
                }
            }
        } catch (Exception ex) {}
    }
}