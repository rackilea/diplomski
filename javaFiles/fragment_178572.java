public class DatabaseHandler extends SQLiteOpenHelper
{
    // DATABASE VERSION
    private static final int DATABASE_VERSION = 1;
    // DATABASE NAME
    private static final String DATABASE_NAME = "Car Dealer";
    // PREFERRED THE NAME "STAR DEALERSHIP CUSTOMER DATABASE"
// CUSTOMER TABLE NAME
    public static final String TABLE_CUSTOMERS = "Customers";


    // CUSTOMER TABLE COLUMN NAMES
    private static final String KEY_ID = "ID";
    private static final String KEY_FNAME = "First";
    private static final String KEY_LNAME = "Last";
    private static final String KEY_CAR_MAKE = "Make";
    private static final String KEY_CAR_MODEL = "Model";
    private static final String KEY_CAR_COST = "Cost";

    DatabaseHandler(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    // CREATE TABLES
    @Override
    public void onCreate(SQLiteDatabase dh)
    {
        String CREATE_TABLE_CUSTOMERS = "CREATE TABLE " + TABLE_CUSTOMERS + "("
                + KEY_ID +" INTEGER PRIMARY KEY,"
                + KEY_FNAME +" TEXT,"
                + KEY_LNAME +" TEXT,"
                + KEY_CAR_MAKE  +" TEXT,"
                + KEY_CAR_MODEL +" TEXT,"
                + KEY_CAR_COST +" NUMERIC" + ")";
        dh.execSQL(CREATE_TABLE_CUSTOMERS);
    }
    // UPGRADING DATABASE
    @Override
    public void onUpgrade(SQLiteDatabase dh, int oldVersion, int newVersion)
    {
        // DROP OLDER TABLE IF EXISTED
        dh.execSQL("DROP TABLE IF EXISTS " + TABLE_CUSTOMERS);

        // CREATE TABLES AGAIN
        onCreate(dh);
    }
    /**
     * All CRUD (CREATE, READ, UPDATE, DELETE) OPERATIONS
     */
// INSERT VALUES TO TABLE CUSTOMERS

    public void addCustomers(Customer customer)
    {
        SQLiteDatabase dh = this.getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_FNAME, customer.getFName());
        values.put(KEY_LNAME, customer.getLName() );
        values.put(KEY_CAR_MAKE, customer.get_CarMake());
        values.put(KEY_CAR_MODEL, customer.get_CarModel());
        values.put(KEY_CAR_COST, customer.get_CarCost());

        dh.insert(TABLE_CUSTOMERS, null, values);
        dh.close();
    }
    /**
     *GETTING ALL CUSTOMERS
     **/
    public List<Customer> getAllCustomers()
    {
        List<Customer> customerList = new ArrayList<Customer>();
        // SELECT ALL QUERY
        String selectQuery = "SELECT  * FROM " + TABLE_CUSTOMERS;

        SQLiteDatabase dh = this.getWritableDatabase();
        Cursor cursor = dh.rawQuery(selectQuery, null);

        // LOOP THROUGH ALL ROWS & ADD TO LIST
        if (cursor.moveToFirst())
        {
            do {
                Customer customer = new Customer();
                customer.setID(Integer.parseInt(cursor.getString(0)));
                customer.setFName(cursor.getString(1));
                customer.setLName(cursor.getString(2));
                customer.set_CarMake(cursor.getString(3));
                customer.set_CarModel(cursor.getString(4));
                customer.set_CarCost(cursor.getDouble(5));

                // ADDING CUSTOMER TO LIST
                customerList.add(customer);
            } while (cursor.moveToNext());
        }
        // CLOSE OUT RAW QUERY CALL
        cursor.close();
        // RETURN CUSTOMER LIST
        return customerList;
    }
    /**
     *UPDATING SINGLE CUSTOMER
     **/
    public int updateCustomer(Customer customer, long id)
    {
        if (customer == null) {
            return 0;
        }
        SQLiteDatabase dh = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_FNAME, customer.getFName());
        values.put(KEY_LNAME, customer.getLName());
        values.put(KEY_CAR_MAKE, customer.get_CarMake());
        values.put(KEY_CAR_MODEL, customer.get_CarModel());
        values.put(KEY_CAR_COST, customer.get_CarCost());

        // UPDATING ROW
        return dh.update(TABLE_CUSTOMERS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(id) });
    }
    /**
     *DELETING SINGLE CUSTOMER
     **/
    public boolean deleteCustomer(long Id)
    {
        boolean rv = false;
        SQLiteDatabase dh = this.getWritableDatabase();
        rv = (dh.delete(TABLE_CUSTOMERS, KEY_ID + " = ?",
                new String[] { String.valueOf(Id) }) > 0);
        dh.close();
        return rv;
    }
}