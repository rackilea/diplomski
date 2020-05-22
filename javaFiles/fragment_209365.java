private static final int TYPE_ITEM = 0; 
private static final int TYPE_SEPARATOR = 1; 

public View getView(int position, View convertView, ViewGroup parent)  {
    ViewHolder holder = null;
    int rowType = getItemViewType(position);
    View View;
    if (convertView == null) {
        holder = new ViewHolder();
        switch (rowType) {
            case TYPE_ITEM:
                convertView = mInflater.inflate(R.layout.task_details_row, null);
                holder.View=getItem(position).getView(mInflater, convertView);
                break;
            case TYPE_SEPARATOR:
                convertView = mInflater.inflate(R.layout.task_detail_header, null);
                holder.View=getItem(position).getView(mInflater, convertView);
                break;
        }
        convertView.setTag(holder);
    }
    else
    {
        holder = (ViewHolder) convertView.getTag();
    }
    return convertView; 
} 

public static class ViewHolder {
    public  View View; } 
}