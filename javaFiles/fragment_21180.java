ParseQuery<ParseObject> query = ParseQuery.getQuery("flyerDataFetch");
    query.findInBackgroud(new FindCallBack<TableClass>(){


        @Override
        public void done(ParseObject List<TableName> list, com.parse.ParseException e) {
            if (e == null) {

       // GENERATE LOOP HERE AND GET ALL DATA OF LIST INTO YOUR LOCAL LIST WHICH YOU ARE PASSING TO ADAPTER OF RECYCLER VIEW
      //I am telling you to add loop so you can learn.. 
                Information information = new Information();
                information.partyName = parseObject.getString("partyName");
                information.partyPromoterName = parseObject.getString("partyCost");
                information.partyCost = parseObject.getString("partyName");

                information.flyerPic = parseObject.getParseFile("partyFlyerImage");
                information.partyPromoterPic = parseObject.getParseFile("partyPromoterImage");

                data.add(information);
            } else {
                // something went wrong
            }