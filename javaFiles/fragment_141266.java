Widget.Builder builder = new Widget.Builder(Widget.BUTTON);

builder.withWidgetBackingService(url, resource, id);
builder.withWidgetStyle(bgColor, lineWidth, fontStyle);
builder.withMouseover("Not required");

Widget example = builder.build();