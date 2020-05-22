List<DataObj> arr_filteredlist = new ArrayList<>();
for(DataObj e : arr_datalist) {
    if(e.i_age > 32 && e.str_address.equals("city2")) {
        arr_filteredlist.add(e);
    }
}