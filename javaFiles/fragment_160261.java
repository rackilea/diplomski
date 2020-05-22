Cursor mCursor = null;
Cursor dataCursor = null;
Cursor itemCursor = null;
String Query = "SELECT * FROM Requests";
mCursor = myDb.rawQuery(Query, null);
transHistory = new ArrayList<HistoryHeader>();
//allGridHistory = new ArrayList<ArrayList<GridItems>>(); // Changed2
//gridHistory = new ArrayList<GridItems>();
int count = 1;
if(mCursor.getCount()!=0) {
    while (mCursor.moveToNext()) {
        String reqDate = mCursor.getString(mCursor.getColumnIndex("RequestDate"));
        String reqTransType = mCursor.getString(mCursor.getColumnIndex("TransType"));
        String reqTotalAmt = mCursor.getString(mCursor.getColumnIndex("AmtTotal"));
        String reqPCode = mCursor.getString(mCursor.getColumnIndex("Property"));
        String BaseId = mCursor.getString(0);
        HistoryHeader history = new HistoryHeader(count, reqDate, reqTransType, reqTotalAmt);

        String Query2 = "SELECT * FROM Projects WHERE PrjCode = '"+ mCursor.getString(3) +"'";
        dataCursor = myDb.rawQuery(Query2, null);
        if (dataCursor.getCount()!=0){
            while (dataCursor.moveToNext()){
                String reqPName = dataCursor.getString(dataCursor.getColumnIndex("PrjName"));
                history.setItemList(createItems(reqPCode, reqPName, 1));
            }
        }

        String Query3 = "SELECT * FROM ReqLine WHERE Base_Id = "+ BaseId;
        itemCursor = myDb.rawQuery(Query3, null);
        if (itemCursor.getCount()!=0) {
            gridHistory = new ArrayList<GridItems>(); // Added
            while (itemCursor.moveToNext()) {
                String reqPurpose = itemCursor.getString(itemCursor.getColumnIndex("Purpose"));
                String reqAmount = itemCursor.getString(itemCursor.getColumnIndex("AmtLine"));
                Integer reqNum = itemCursor.getInt(itemCursor.getColumnIndex("Linenum"));
                GridItems test = new GridItems(reqNum, reqPurpose, reqAmount);
                gridHistory.add(test);
            }
            history.setItemGrid(gridHistory); // Changed2
        }

        transHistory.add(history);
        count++;
    }
}

final ExpandableListView _Content = (ExpandableListView) rootView.findViewById(R.id.historyList);
_Content.setIndicatorBounds(5,5);
HistoryAdapter exAdpt = new HistoryAdapter(getActivity(), transHistory); // Changed2