// assuming userPreferences is java.util.prefs.Preferences
String colorCode = userPreferences.get("COLOR_CODE", "#ededed");
switch (colorCode.toLowerCase()) {
    case "#ededed": defaultColorRB.setSelected(true); break;
    case "#ffffff": whiteColorRB.setSelected(true); break;
    ...
    default: /* none selected - not sure what you want to do in that case */ break;
}