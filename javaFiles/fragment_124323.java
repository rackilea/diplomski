import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class HomeMenu extends AppCompatActivity implements View.OnClickListener {

private CardView veganMenu,halalMenu,vegeterianMenu,kosherMenu;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home_menu);
    getSupportActionBar().setDisplayShowHomeEnabled(true);

    veganMenu = (CardView) findViewById(R.id.vegan_menu);
    halalMenu = (CardView) findViewById(R.id.vegetarian_menu);
    vegeterianMenu = (CardView) findViewById(R.id.halal_menu);
    kosherMenu = (CardView) findViewById(R.id.kosher_menu);

    veganMenu.setOnClickListener(this);
    halalMenu.setOnClickListener(this);
    vegeterianMenu.setOnClickListener(this);
    kosherMenu.setOnClickListener(this);
}

public void onClick(View v) {
    Intent intent = new Intent(this,Home.class)
    switch (v.getId()) {
        case R.id.vegan_menu:
            intent.putExtra("STRING_I_NEED", "vegan");
            startActivity(intent);
            break;
        case R.id.vegetarian_menu:
            intent.putExtra("STRING_I_NEED", "vegetarian");
            startActivity(intent);
            break;
        case R.id.halal_menu:
            intent.putExtra("STRING_I_NEED", "halal");
            startActivity(intent);      
            break;
        case R.id.kosher_menu:
            intent.putExtra("STRING_I_NEED", "kosher");
            startActivity(intent);      
            break;
    }
}
}