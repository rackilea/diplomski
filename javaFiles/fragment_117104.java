private class ValueFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if(constraint == null || constraint.length() == 0){
                results.values = originalList;
                results.count = originalList.size();
            }
            else {

                List<Exhibition> nExhList = new ArrayList<>();

                for(Exhibition e : list){
                    if (e.getName().toUpperCase().startsWith(constraint.toString().toUpperCase())){
                        nExhList.add(e);
                    }
                }

                results.values= nExhList;
                results.count=nExhList.size();
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {
            if(results.count==0){
                notifyDataSetInvalidated();
            }
            else{
                list = (ArrayList<Exhibition>)results.values;
                notifyDataSetChanged();
            }
        }

    }