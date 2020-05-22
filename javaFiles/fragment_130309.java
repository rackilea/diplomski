public void Deletedata (View view)
{
    int position = cursor.getPosition();

    int dRow;
    dRow = Integer.parseInt((cursor.getString(0)));
    db.deleteRecord(dRow);      
    Toast.makeText(this, "Contact Deleted", Toast.LENGTH_LONG).show();

    // Refresh the cursor
    cursor.close();
    cursor = db.getAllRecords();
    cursor.moveToPosition(position);

    Nextdata(view);             
}