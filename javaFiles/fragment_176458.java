//hosts: the list of data used to build up the hierarchy shown by this adapter's parent list.
private class MyExpandableListAdapter extends BaseExpandableListAdapter
{
    private LayoutInflater inflater;

    public MyExpandableListAdapter()
    {
        inflater = LayoutInflater.from(Binding.this);
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent)
    {
        final Host host = hosts.get(groupPosition);
        final boolean needsLargeView = isExpanded && (host.getTitle() != null) && (host.getTitle().length() > 0);
        if (needsLargeView)
            convertView = inflater.inflate(R.layout.grouprow_expanded, parent, false);
        else
            convertView = inflater.inflate(R.layout.grouprow, parent, false);
        convertView.setBackgroundResource(host.getBackgroundResource(isExpanded));
        [...]
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent)
    {
        final Host host = hosts.get(groupPosition);
        final NagService service = host.getServices().get(childPosition);
        convertView = inflater.inflate(R.layout.childrow, parent, false);
        convertView.setBackgroundResource(host.getChildBackgroundResource());
        convertView.findViewById(R.id.servicename_status).setBackgroundResource(service.getStatusBackground());
        [...]
        CheckBox alertChb = (CheckBox) convertView.findViewById(R.id.alert);
        alertChb.setChecked(service.isNeedsAlert());
        alertChb.setOnCheckedChangeListener(new YourCheckChangedListener(service));
        return convertView;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition)
    {
        return hosts.get(groupPosition).getServices().get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition)
    {
        return childPosition;
    }

    @Override
    public int getChildrenCount(int groupPosition)
    {
        return hosts.get(groupPosition).getServices().size();
    }

    @Override
    public Object getGroup(int groupPosition)
    {
        return hosts.get(groupPosition);
    }

    @Override
    public int getGroupCount()
    {
        return hosts.size();
    }

    @Override
    public long getGroupId(int groupPosition)
    {
        return groupPosition;
    }

    @Override
    public void notifyDataSetChanged()
    {
        super.notifyDataSetChanged();
    }

    @Override
    public boolean isEmpty()
    {
        return ((hosts == null) || hosts.isEmpty());
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition)
    {
        return true;
    }

    @Override
    public boolean hasStableIds()
    {
        return true;
    }

    @Override
    public boolean areAllItemsEnabled()
    {
        return true;
    }
}