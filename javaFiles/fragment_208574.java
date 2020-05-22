public void deSelectParent()
    {
        for (int i=0;i<data.size();i++)
        {
            data.get(i).setSelected(false);
        }
        notifyDataSetChanged();
    }

public static class ParentEvent {
        View view;
        int position;
    }