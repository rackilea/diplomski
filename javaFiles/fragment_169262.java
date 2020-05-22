@Override
public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
    // Create a switch that switches on the specific child position.
    switch(childPosition) {
    case 0:
        // Go to child #0 specific class.
        Intent child0Intent = new Intent(this, Child0Activity.class);
        startActivity(child0Intent);
        break;
    case 1:
        // Go to child #1 specific class.
        Intent child1Intent = new Intent(this, Child1Activity.class);
        startActivity(child1Intent);
        break;
    }
    return false;
}