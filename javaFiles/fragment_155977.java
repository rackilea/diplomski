try {// UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if (info.getName().equals("Nimbus")) {
            UIManager.setLookAndFeel(info.getClassName());
            UIDefaults defaults = UIManager.getLookAndFeelDefaults();
            defaults.put("Table.gridColor", new Color (214,217,223));
            defaults.put("Table.disabled", false);
            defaults.put("Table.showGrid", true);
            defaults.put("Table.intercellSpacing", new Dimension(1, 1));
            break;
        }
    }
} catch (Exception e) {
    //e.printStackTrace();
}