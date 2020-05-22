public class PrepaidLBO extends PrepaidBase  implements View.OnClickListener {


Button chobeesButton;
public PrepaidLBO()
{
    setPackageInformation("Package Name", "Your Price", "*123#", "Your Title");
}

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.chobeesghantay);
    chobeesButton = (Button) findViewById(R.id.chobeesButton);
    chobeesButton.setOnClickListener(this);
}

@Override
public void onClick(View v)
{
    activatePackage();
}