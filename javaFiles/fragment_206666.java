for (Component a : frame.getLayeredPane().getComponents()) {
    System.out.println(a.toString());
    if (a.toString().contains("MetalTitlePane")) {
        for (Component b : ((Container)a).getComponents()) {
            System.out.println(b.toString());
            if (b.toString().contains("SystemMenuBar")) {
                for (Component c : ((Container)b).getComponents()) {
                    System.out.println(c.toString());
                    for (Component d : ((JMenu)c).getPopupMenu().getComponents()) {
                        System.out.println(d.toString());
                        if (d.toString().contains("JMenu")) {
                            d.setFont(font);
                        }
                    }
                }
            }
        }
    }
}