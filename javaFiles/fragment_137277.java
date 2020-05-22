do {
    // Initialize History
    History = new HistoryInfoClass();

    History.Time = c.getInt(1);
    History.Time1 = c.getInt(2);

    historyArrayList.add(History);
    i++;
} while (c.moveToNext());