@Override
            protected FilterResults performFiltering(CharSequence constraint)
            {
                FilterResults filterResults = new FilterResults();

                // ADDED CODE: TO FIX ERROR "The content of the adapter has changed but ListView did not receive a notification":
                ArrayList <String> resultListTemp = new ArrayList <String> ();

                if (constraint != null)
                {
                    // ADDED CODE: TO STOP TYPING DELAY & TO FIX ERROR: "The content of adapter has changed but ListView did not receive a notification"
                    if (conn != null)
                    {
                        conn.disconnect();
                    }

                    // CHANGED CODE: TO FIX ERROR "The content of the adapter has changed but ListView did not receive a notification":
                    resultListTemp.addAll(autocomplete(constraint.toString()));

                    filterResults.values = resultListTemp;
                    filterResults.count = resultListTemp.size();
                }
                return filterResults;
            }


            @Override
            protected void publishResults(CharSequence constraint, FilterResults results)
            {
                // ADDED CODE: TO FIX ERROR "The content of the adapter has changed but ListView did not receive a notification":
                resultList = (ArrayList <String>) results.values;

                if (results != null && results.count > 0)
                {
                    notifyDataSetChanged();
                }
                else
                {
                    notifyDataSetInvalidated();
                }
            }


            private ArrayList<String> autocomplete(String input)
            {
                // CHANGED CODE: TO FIX ERROR "The content of the adapter has changed but ListView did not receive a notification":
                ArrayList<String> resultList = new ArrayList <String> ();
                .....
                .....
            }