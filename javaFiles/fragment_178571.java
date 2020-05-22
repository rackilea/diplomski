public class CustomerRcrdActivity extends AppCompatActivity {

    private EditText FName, LName, CarMake, CarModel, CarCost;
    private String F_Name;
    private String L_Name;
    private String Car_Make;
    private String Car_Model;
    private double d_Car_Cost;
    private DatabaseHandler dh;
    private dataAdapter da;
    private Customer dataModel;
    private ListView lv;
    private long mId;

    //<<<<<<<<<< new class variables
    private String original_FName, original_LName, original_CarMake, original_CarModel, original_CarCost;
    private boolean mLoaded = false;
    private Button mViewButton, mUpdateButton, mAddButton, mDeleteButton;
    private ArrayList<Customer> mCustomers = new ArrayList<>();
    private List<EditText> mAlleditTexts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_rcrd);

        // GET Intent THAT STARTED ACTIVITY
        Intent intent = getIntent();

        // INSTANTIATE DATABASE HANDLER
        dh = new DatabaseHandler(this);

        FName = (EditText) findViewById(R.id.editText2_FName);
        LName = (EditText) findViewById(R.id.editText2_LName);
        CarMake = (EditText) findViewById(R.id.editText2_CarMake);
        CarModel = (EditText) findViewById(R.id.editText2_CarModel);
        CarCost = (EditText) findViewById(R.id.editText2_CarCost);

        //<<<<<<<<<<< ADDED
        mAlleditTexts.add(FName);
        mAlleditTexts.add(LName);
        mAlleditTexts.add(CarMake);
        mAlleditTexts.add(CarModel);
        mAlleditTexts.add(CarCost);
        lv = (ListView) findViewById(R.id.lv);
        //<<<<<<<<<< END OF ADDED

        mViewButton = (Button) findViewById(R.id.button_CR_view);
        mAddButton = (Button) findViewById(R.id.button_CR_add);
        mUpdateButton = (Button) findViewById(R.id.button_CR_update);
        mDeleteButton = (Button) findViewById(R.id.button_CR_delete);

        mViewButton.setVisibility(View.GONE); // never Show and free screen space
        mViewButton.setText("CLEAR"); // Hijack View Button for clear data
        mViewButton.setVisibility(View.VISIBLE); // Show the View (now CLEAR)
        mAddButton.setEnabled(false); // Can't click Add as nothing to add
        mUpdateButton.setEnabled(false); // Can't click Update nothing to update
        mDeleteButton.setEnabled(false); // Can't click Delete as nothing to delete
        setOriginalValues();
        ShowRecords(); //<<<< Always show the list no need for View button
        setEditTextFocusChangedListener(mAlleditTexts);
    }

    //<<<<<<<<<< NEW METHOD
    private void setEditTextFocusChangedListener(List<EditText> edit_texts) {
        for (EditText e: edit_texts) {

            e.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View view, boolean b) {
                    if (areOriginalValuesChanged()) {
                        if (mLoaded) {
                            mUpdateButton.setEnabled(true);
                            mDeleteButton.setEnabled(false);
                            mAddButton.setEnabled(false);
                        } else {

                        }
                    } else {
                        if (!mLoaded) {
                            mAddButton.setEnabled(true);
                        } else {
                            mAddButton.setEnabled(false);
                        }
                    }
                }
            });
        }
    }

    //<<<<<<<<<< NEW METHOD
    private void setOriginalValues() {
        original_FName = FName.getText().toString();
        original_LName = LName.getText().toString();
        original_CarMake = CarMake.getText().toString();
        original_CarModel = CarModel.getText().toString();
        original_CarCost = CarCost.getText().toString();
    }

    //<<<<<<<<<< NEW METHOD
    private boolean areOriginalValuesChanged() {
        if (original_FName.equals(FName.getText().toString())
                && original_LName.equals(LName.getText().toString())
                && original_CarMake.equals(CarMake.getText().toString())
                && original_CarModel.equals(CarModel.getText().toString())
                && original_CarCost.equals(CarCost.getText().toString())
                ) {
            return false;
        }
        return true;
    }

    //<<<<<<<<<< NEW METHOD
    private void clearEditTexts(List<EditText> editTexts) {
        for (EditText e: editTexts) {
            e.setText("");
        }
        setOriginalValues();
        mLoaded = false;
    }

    public void buttonClicked(View view)
    {
        int id = view.getId();

        switch (id)
        {
            case R.id.button_CR_update:
                // CALL updateCustomer() TO UPDATE CUSTOMER RECORDS
                updateCustomer();
                mLoaded = false;
                break;

            case R.id.button_CR_add:
                // CALL addCustomer() TO ADD TO DATABASE
                addCustomer();
                clearEditTexts(mAlleditTexts);
                mLoaded = false;

                // START NEW ACTIVITY WHEN ADD BUTTON CLICKED
                //Intent intent = new Intent(this, DatabaseHandler.class);
                //startActivity(intent);

                break;

            case R.id.button_CR_delete:
                // CALL deleteCustomer() TO DELETE CUSTOMER RECORD
                deleteCustomer();
                break;

            case R.id.button_CR_view:
                // CALL viewCustomer() TO VIEW CUSTOMER RECORD
                // START NEW ACTIVITY WHEN ADD BUTTON CLICKED
                //Intent intent2 = new Intent(this, CustomerDBActivity.class);
                //startActivity(intent2);

                // CALL showRecords() TO VIEW CUSTOMER RECORD VIA ListView
                clearEditTexts(mAlleditTexts);
                mLoaded = false;
                mAddButton.setEnabled(true);
                mUpdateButton.setEnabled(false);
                mDeleteButton.setEnabled(false);
                break;
        }
        ShowRecords(); // Update the List irrespective of button clicked
    }


    private void updateCustomer()
    {
        getValues();
         if (dh.updateCustomer(dataModel, mId)>0) {
             Toast.makeText(getApplicationContext(), "Customer Updated Successfully", Toast.LENGTH_LONG).show();
         } else {
             Toast.makeText(getApplicationContext(), "Customer Not Updated", Toast.LENGTH_LONG).show();
         }
    }
    // INSERT DATA INTO DATABASE
    private void addCustomer()
    {
        boolean ok_to_add = true;
        getValues();
        if (F_Name == null || F_Name.length() < 1) ok_to_add = false;
        if (L_Name == null || L_Name.length() < 1) ok_to_add = false;
        if (Car_Make == null || Car_Make.length() < 1) ok_to_add = false;
        if (Car_Model == null || Car_Model.length() < 1) ok_to_add = false;
        if (ok_to_add) {
            dh.addCustomers(new Customer(F_Name, L_Name, Car_Make, Car_Model, d_Car_Cost));
            Toast.makeText(getApplicationContext(), "Customer Added Successfully", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Unable To Add - Some Data hasn't been given", Toast.LENGTH_LONG).show();
        }
    }

    private void deleteCustomer()
    {
        getValues();
         if (dh.deleteCustomer(mId)) {
             Toast.makeText(getApplicationContext(), "Customer Deleted Successfully", Toast.LENGTH_LONG).show();
         } else {
             Toast.makeText(getApplicationContext(), "Customer Not Deleted", Toast.LENGTH_LONG).show();
         }
    }

    // FUNCTION TO GET VALUES FROM EditText
    private void getValues()
    {

        F_Name = FName.getText().toString();
        L_Name = LName.getText().toString();
        Car_Make = CarMake.getText().toString();
        Car_Model = CarModel.getText().toString();
        String car_Cost = CarCost.getText().toString();
        if (car_Cost.length() < 1) {
            car_Cost = "0.00";
        }
        d_Car_Cost = Double.parseDouble(car_Cost);

    }
    // RETRIEVE DATA FROM DATABASE & SET TO LIST VIEW
    //<<<<<<<<<< CHANGED QUITE A BIT
    // Introduced single Customer List with class scope rather than create new list and adapter everytime
    //      i.e. mCustomers
    // Always clear mCustomers and rebuild from database
    // if da (the adapter) is null and therefore hasn't been instantiated, instantiate it just once
    // otherwsie always notify the adapter that the data (mCustomer) has changed
    // Added code to the Listener (added just the once now) to set the edit text's to the values
    // of the clicked item in the list (load the data)
    //  setting flag to say that the data has just been loaded.
    //  also setting the original values to the new data
    private void ShowRecords()
    {
        mCustomers.clear();
        mCustomers.addAll(dh.getAllCustomers());
        //final ArrayList<Customer> customers = new ArrayList<>(dh.getAllCustomers());
        //final Customer customers = new Customer(dh.getAllCustomers());
        if (da == null) {
            da = new dataAdapter(this, mCustomers);
            //final dataAdapter data = new dataAdapter(this, mCustomers); //<<<< Shouldn't create a new adapter everytime

            lv.setAdapter(da);

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    dataModel = mCustomers.get(position);
                    //<<<<<<<<<< Added
                    FName.setText(dataModel.getFName());
                    LName.setText(dataModel.getLName());
                    CarMake.setText(dataModel.get_CarMake());
                    CarModel.setText(dataModel.get_CarModel());
                    CarCost.setText(String.valueOf(dataModel.get_CarCost()));
                    mLoaded = true;
                    setOriginalValues();
                    mDeleteButton.setEnabled(true);
                    mUpdateButton.setEnabled(false);
                    mAddButton.setEnabled(false);
                    mId = dataModel.getID();
                    //<<<<<<<<<< End of Added
                    Toast.makeText(getApplicationContext(), String.valueOf(dataModel.getID()), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            da.notifyDataSetChanged();
        }
    }
}