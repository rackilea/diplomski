package ankitkaushal.app.healthysizing;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.io.IOException;
import java.util.ArrayList;

 public class shoppingCart extends ActionBarActivity implements OnItemDeletedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        final DatabaseHelper dbhelper;
        final ListView listView;
        final ListAdapter cartAdapter;

        dbhelper = new DatabaseHelper(getApplicationContext());
        try {
            dbhelper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }

        listView = (ListView) findViewById(R.id.itemsInCartList);
        ArrayList<Item> cartList = dbhelper.getItemsInCart();

        if (cartList != null) {
            cartAdapter = new CartItemsAdapter(getApplicationContext(), cartList);
            cartAdapter.setOnItemDeletedListener(this);
            listView.setAdapter(cartAdapter);
        }

        listView.setEmptyView(findViewById(R.id.emptyCartMessage));

        displayTotalPrice();
    }

    private void displayTotalPrice() {

        TextView displayTotalPrice = (TextView) findViewById(R.id.totalCartPrice);
        String totalCartPrice = dbhelper.getTotalCartPrice();

        if (totalCartPrice != null) {
            displayTotalPrice.setText("Total Price: $" + totalCartPrice);
        }

        else {
            displayTotalPrice.setText("Total Price: $0.00");
        }
    }

    @Override
    public void onItemDeleted() {
        displayTotalPrice();
    }
}