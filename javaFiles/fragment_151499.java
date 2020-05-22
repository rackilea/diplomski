public Main() {
    // cvars contains variables from JPong.ini (It's an extended class from the ini4j library)
    cvars = CVarList.getInstance();

    // get(sectionName, optionName, classtype, defaultValue)
    setSize(cvars.get("Window", "width", int.class, 800),
            cvars.get("Window", "height", int.class, 600));
    setTitle(cvars.get("Window", "title", String.class, "JPong"));
    setResizable(cvars.get("Window", "resizable", boolean.class, false));
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    TableWrapperPanel wrapper = new TableWrapper(table);
    add(wrapper );
    pack();
    setVisible(true);
}