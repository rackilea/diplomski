Collection<DataObj> filteredColl = Collections2.filter(arr_datalist,
    new Predicate<DataObj>() {
        @Override
        boolean apply(DataObj e) {
            return e.i_age > 32 && e.str_address.equals("city2");
        }
        // + overrides equals
    });
List<DataObj> arr_filteredlist = new ArrayList<>(filteredColl);