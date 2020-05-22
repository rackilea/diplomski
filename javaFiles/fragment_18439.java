public class TemoActivity extends Activity {

public Spinner catspinner,planspinner3,planspinner1,planspinner2;


protected void onCreate(Bundle mbfSplash) {
        super.onCreate(mbfSplash);
        setContentView(R.layout.main);

chooseCategory();
choosePersonalPlan();
chooseLargeBusPlan();
chooseSmallMedPlan();
}

public void chooseCategory() {

    catspinner = (Spinner) findViewById(R.id.catspinner);
    ArrayAdapter<CharSequence> catAdapter = ArrayAdapter.createFromResource(this, R.array.ducategory, android.R.layout.simple_spinner_item);
    catAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    catspinner.setAdapter(catAdapter);
    catspinner.setOnItemSelectedListener(new planOnClickListener());
}
private void choosePersonalPlan(){
    planspinner1 = (Spinner) findViewById(R.id.planspinner);
    List<String> planlist = new ArrayList<String>();
    planlist.add("Elite Regular Plan");
    planlist.add("Elite Super Plans");
    planlist.add("Emirati Plan");
    planlist.add("Pay As You Go");
    planlist.add("Visitor Mobile Line");
    ArrayAdapter<String> planAdapter1 = new ArrayAdapter<String>(this,
        android.R.layout.simple_spinner_item, planlist);
    planAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    planspinner1.setAdapter(planAdapter1);

}

private void chooseLargeBusPlan(){

    planspinner2 = (Spinner) findViewById(R.id.planspinner);
    List<String> planlist1 = new ArrayList<String>();
    planlist1.add("Premier Plan");
    planlist1.add("The Executive Plan");
    planlist1.add("Business Circle Plan");
    planlist1.add("Business Diamond Plan");
    ArrayAdapter<String> planAdapter2 = new ArrayAdapter<String>(this,
        android.R.layout.simple_spinner_item, planlist1);
    planAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    planspinner2.setAdapter(planAdapter2);


}
private void chooseSmallMedPlan(){

    planspinner2 = (Spinner) findViewById(R.id.planspinner);
    List<String> planlist2 = new ArrayList<String>();
    planlist2.add("Business Super Plan");
    planlist2.add("Her Business Super Plan");
    planlist2.add("Business Circle Plan");
    planlist2.add("Pay As you Go® Plus");
    ArrayAdapter<String> planAdapter3 = new ArrayAdapter<String>(this,
        android.R.layout.simple_spinner_item, planlist2);
planAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
planspinner2.setAdapter(planAdapter3);

}


public class planOnClickListener implements OnItemSelectedListener {

         @Override
        public void onItemSelected(AdapterView<?> parent, View v, int pos,
                long id) {

            parent.getItemAtPosition(pos);  

            if (pos==0){
            choosePersonalPlan();   
            }else if (pos==1){
            chooseLargeBusPlan();
            } else if (pos==2){
            chooseSmallMedPlan();
 }
        }
        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub

        }
        }
}