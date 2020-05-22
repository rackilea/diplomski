public void deSelectChild()
    {
        for (int i=0;i<data.size();i++)
        {
            datachild.get(i).setSelected(false);
        }
        notifyDataSetChanged();
    }

public static class ChildEvent {
        View view;
        int position;
    }