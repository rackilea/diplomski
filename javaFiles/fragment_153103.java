@Override
        protected FilterResults performFiltering(CharSequence constraint) {

            constraint = constraint.toString().toLowerCase();
            FilterResults result = new FilterResults();
            if(constraint != null && constraint.toString().length() > 0)
            {
                ArrayList<State> filteredItems = new ArrayList<State>();

                for(int i = 0, l = getCount(); i < l; i++)
                {
                    State m = getItem(i);
                    if(m.getName().toLowerCase().contains(constraint))
                        filteredItems.add(m);
                }
                result.count = filteredItems.size();
                result.values = filteredItems;
            }
            else
            {
                ArrayList<State> allItems = new ArrayList<State>();
                for(int i = 0, l = getCount(); i < l; i++)
                {
                    State m = getItem(i);
                    allItems.add(m);
                }
                synchronized(this)
                {
                    result.values = allItems;
                    result.count = allItems.size();
                }
            }
            return result;
        }