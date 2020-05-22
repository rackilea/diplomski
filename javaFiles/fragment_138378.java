// Old
final TextView view0 = (TextView)activity.findViewById(id);
// New
final View     view1 = activity.findViewById(id);
final TextView view2 = activity.findViewById(id);
// Not useful
final View     view3 = activity.<TextView>findViewById(id);