public class ProductActivity extends Activity {

private ArrayList<Product> _products = new ArrayList<Product>();

private EditText _nameEdtx;
// and other widgets

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // attach activity to layout and widgets in layout
}

// assuming your button has onClick="handleAddButtonClicked"
public void handleAddButtonClicked( View vw ) {
    _products.add( new Product( _nameEdtx.getText().toString() ) );
}

class Product {
    String _productName;
    // ... and so on
    public Product( String productName ) {
        _productName = productName;
        // and so on, with other member variables
    }
}
}