@Override
    public String getCost() {
        final String[] productValue = {null};
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>
        query.whereEqualTo("productName", Capris);
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> list, ParseException e) {
                if (e == null) { //no exception, hence success
                    productValue[0] = list.get(0).getString("productPrice");
                }
            }
        });
        return productValue[0];
    }