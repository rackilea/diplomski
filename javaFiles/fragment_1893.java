public List<Movie> getAllData()
{
    List<Movie> movies_list = new ArrayList<>();
    SQLiteDatabase db = this.getWritableDatabase();
    Cursor res = db.rawQuery("SELECT * FROM movie_collection", null);
    while(res.moveToNext())
    {
        movies_list.add(new Movie(res.getString(1)+"\n", res.getString(2)+"\n", res.getString(3)+"\n", R.drawable.gladiator));
    }
    res.close();
    return movies_list;
}