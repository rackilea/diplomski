while(data.moveToNext())
            {
                arrayListTitle.add(data.getString(1));
                arrayListYear.add(data.getString(2));
                arrayListRating.add(data.getString(3));
                arrayListThumb.add(data.getString(4));
                arrayListUrl.add(data.getString(5));
             }