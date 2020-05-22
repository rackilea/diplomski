public class DrinkingBuddy extends Activity {
/** Called when the activity is first created. */

 double StandardDrinks = 0;
 double BeerOunces = 12;
double BeerPercentAlcohol = .05;
 double BeerDrink = BeerOunces * BeerPercentAlcohol;
 double BeerDrinkFinal = BeerDrink * 1.6666666;
 double ShotOunces = 1.5;
 double ShotPercentAlcohol = .4;
 double ShotDrink = ShotOunces * ShotPercentAlcohol;
 double ShotDrinkFinal = ShotDrink * 1.6666666;
 double WineOunces = 5;
 double WinePercentAlcohol = .12;
double WineDrink = WineOunces * WinePercentAlcohol;
double WineDrinkFinal = WineDrink * 1.6666666;
 double OtherOunces;
 double OtherPercentAlcohol;
 double OtherDrink = OtherOunces * (OtherPercentAlcohol * .01);
 double OtherDrinkFinal = OtherDrink * 1.6666666;
 double GenderConstant = 7.5; //9 for female
 double Weight = 180;
 double TimeDrinking = 60;
 double Hours = TimeDrinking / 60;
 double Bac;


@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    Button button = (Button) findViewById(R.id.Button01);
    button.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
            StandardDrinks = StandardDrinks + BeerDrinkFinal;
            Toast.makeText(DrinkingBuddy.this, "Mmmm... Beer", Toast.LENGTH_SHORT).show();

        }
        });

Button button4 = (Button) findViewById(R.id.Button05); 
button4.setOnClickListener(new OnClickListener() 
{ 
@Override 
public void onClick(View v) {

            TextView texty;
            Bac = ((StandardDrinks / 2) * (GenderConstant / Weight)) - (0.017 * Hours);
            texty = (TextView) findViewById(R.id.texty1);
            texty.setText("Your BAC is " + Bac );

        }
        });