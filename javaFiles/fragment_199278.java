FormLayout layout = new FormLayout(
“right:max(40dlu;p), 4dlu, 80dlu, 7dlu, ” // 1st major column
+ “right:max(40dlu;p), 4dlu, 80dlu”, // 2nd major column
“”); // add rows dynamically
DefaultFormBuilder builder = new DefaultFormBuilder(layout);
builder.setDefaultDialogBorder();
builder.appendSeparator(“Segment”);
builder.append(“Identifier”, idField);
builder.nextLine();
builder.append(“PTI [kW]”, ptiField);
builder.append(“Power [kW]”, powerField);
builder.append(“len [mm]”, lenField);
builder.nextLine();
builder.appendSeparator(“Diameters”);
builder.append(“da [mm]”, daField);
builder.append(“di [mm]”, diField);
builder.append(“da2 [mm]”, da2Field);
builder.append(“di2 [mm]”, di2Field);
builder.append(“R [mm]”, rField);
builder.append(“D [mm]”, dField);