@Override
    public Filter getFilter() {
        if(customFilter == null){
            customFilter = new CustomFilter();
        }
        return customFilter;
    }