public class ExpandableListAdapter extends BaseExpandableListAdapter {
List<Person>persons; // fill persons

public View getGroupView(int groupPosition, boolean isExpanded,
                View convertView, ViewGroup parent) {
persons.get(groupPosition).getName();
}

public View getChildView(int groupPosition, int childPosition,
                boolean isLastChild, View convertView, ViewGroup parent) {
persons.get(groupPosition).getFriends();
}