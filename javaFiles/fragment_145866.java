@Override
    protected FilterResults performFiltering(CharSequence constraint) {

        FilterResults filterResults = new FilterResults();

        ArrayList<Pair<String, String>> temp_list = null;
        ArrayList<Pair<String, String>> found = new ArrayList<>();

        if (constraint != null) {
            if (!(constraint.toString().isEmpty())) {
                temp_list = MainActivity.Wordlists_Map.get(constraint.toString().substring(0,1).toLowerCase());

                if(temp_list != null){
                    for(Pair<String, String> element : temp_list){
                        if(element.first.startsWith(constraint.toString().toLowerCase())){
                            found.add(element);
                        }
                    }
                }
            }
        }

        filterResults.values = found;
        filterResults.count = found.size();

        return filterResults;
    }