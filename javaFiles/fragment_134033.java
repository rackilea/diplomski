List<String> lst = new ArrayList<>();
Cursor c = db.rawQuery("SELECT * FROM subs", null);
if(c.moveToFirst())
{
    lst.add (c.getString(0));
}