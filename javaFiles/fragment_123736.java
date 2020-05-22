expListAdapter = new ExpandableListAdapter(getApplicationContext());

            expListAdapter.setupTrips(aryAbsence,aryTicket,aryTimeSheet); // Mathod in ExpandableListAdapter class and data in aryLists.

            expList.setAdapter(expListAdapter);

            if (expListAdapter.getChildrenCount(0) >= 1) {
                expList.expandGroup(0);
            }