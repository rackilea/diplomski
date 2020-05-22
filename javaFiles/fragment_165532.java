String[][] buttons = {
    {"id", "menuButton"},
    {"src", ".*homeicon_calendar.*"},
    {"src", ".*cycle_templates.*"},
};
for (String[] button: buttons) {
    if (findANDclick(button)) return;
}