if (n != null) {
        //Adding New Bowler To The Array List At Position 0
        bowlersList.add(0, n);

        //Refreshing The List
        mAdapter.notifyDataSetChanged(bowlerList);

        toggleEmptyBowlers();
    }