//inside your Adapter class;

....

private List<DataObject> mMenuItemObjects;

public SampleRecyclerAdapter(List<DataObject> menuItemObjects) {
    mMenuItemObjects = menuItemObjects;
}

@Override
public void onBindViewHolder(MainMenuViewHolder holder, int position) {
    holder.itemName.setText(mMenuItemObjects.get(position).getName());

    holder.itemIcon.setImageResource(mMenuItemObjects.get(position).getIcon());
}