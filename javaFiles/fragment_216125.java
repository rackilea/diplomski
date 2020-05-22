public void addListenerOnSpinnerItemSelection() {
        mySpinner = (Spinner) findViewById(R.id.GPU_LAYOUT);  
        mySpinner.setOnItemSelectedListener(new myOnItemSelectedListener());
    }

public class myOnItemSelectedListener implements OnItemSelectedListener {       
@Override
public void onItemSelected(AdapterView<?> parent, View arg1, int pos,long arg3)     {           

int position=Arrays.asList(getResources().getStringArray(R.array.GPU_LAYOUT)).indexOf(fecha);           }

@Override
public void onNothingSelected(AdapterView<?> arg0) {        }       
}