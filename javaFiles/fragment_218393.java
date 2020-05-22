import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class ItemsExpandableListAdapter extends BaseExpandableListAdapter {

 private Activity context;
    private Map<String, List<String>> ItemsCategoryCollections;
    private List<String> ItemsCategories;

    public ItemsExpandableListAdapter(Activity context, List<String> Categories,
            Map<String, List<String>> CategoryCollections) {
        this.context = context;
        this.ItemsCategoryCollections = CategoryCollections;
        this.ItemsCategories = Categories;
    }

    public Object getChild(int groupPosition, int childPosition) {
        return ItemsCategoryCollections.get(ItemsCategories.get(groupPosition)).get(childPosition);
    }

    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    public View getChildView(final int groupPosition, final int childPosition,
            boolean isLastChild, View convertView, ViewGroup parent) {
        final String Itemscategory = (String) getChild(groupPosition, childPosition);
        LayoutInflater inflater = context.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.items_child_item, parent, false);
        }


        return convertView;
    }

    public int getChildrenCount(int groupPosition) {
        return ItemsCategoryCollections.get(ItemsCategories.get(groupPosition)).size();
    }

    public Object getGroup(int groupPosition) {
        return ItemsCategories.get(groupPosition);
    }

    public int getGroupCount() {
        return ItemsCategories.size();
    }

    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String ItemsName = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.items_group_item, parent, false);
        }

        return convertView;
    }

    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}