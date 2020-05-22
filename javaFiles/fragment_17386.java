package 'Your package name';



    import android.content.ContentValues;
    import android.content.Context;
    import android.database.Cursor;
    import android.database.SQLException;
    import android.database.sqlite.SQLiteDatabase;

    public class DataBaseAdapter {

        // Database fields

        private Context context;
        private SQLiteDatabase database;
        private DBHelper dbHelper;

        public DataBaseAdapter(Context context) {
            this.context = context;
        }

        public DataBaseAdapter open() throws SQLException {
            dbHelper = new DBHelper(context);
            database = dbHelper.getWritableDatabase();
            return this;
        }

        public void close() {
            dbHelper.close();
        }


        public Cursor fetchAllTAble1data() {
            return database.query("MenuData", new String[] { "id", "Title",
                    "Image", "Description" }, null, null, null, null, null);
        }

        public Cursor fetchAllTable2data() {
            return database.query("RestaurantsData", new String[] {
                    "restaurant_id", "name", "phone", "email", "open_days",
                    "timing", "website", "loc_name", "street", "city", "longitude",
                    "latitude", "zip" }, null, null, null, null, null);
        }

        public void deleteTable(String tablename){
            database.execSQL("drop table if exists "+tablename+';');
        }
        public void createIndividualTable(String query){
            database.execSQL(query);
        }


        public void InsertTable1Data(TAble1 review) {
            ContentValues values = new ContentValues();
            values.put("Name", review.Name);
            values.put("Email", review.Email);
            values.put("Comment", review.Comment);
            values.put("Rating", review.Rating);

            database.insert("ReviewsData", null, values);

        }

        public void InsertTable2Data(TAble2 photos) {
            ContentValues values = new ContentValues();
            values.put("photo", photos.Photos);

            database.insert("PhotosData", null, values);

        }



        public ContentValues createContentValues(String category, String summary,
                String description) {
            ContentValues values = new ContentValues();

            return values;
        }
    }