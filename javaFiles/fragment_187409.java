public void DisplayRecord(Cursor c) {
    Toast.makeText(
            this,
            "Item name" + c.getString(1) + "\n" + "Profit/Loss"
                    + c.getString(5), Toast.LENGTH_SHORT).show();
    }