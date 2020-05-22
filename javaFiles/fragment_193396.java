public class ButtonCalculation { //I don't find any reason to extend MainActivity here

    //also you need a constructor (except if you are using a static method)
    public void ButtonCalculation (){

    }

    public void calculate(ViewGroup root, Context context){

        Spinner spinnerOmadas=(Spinner) root.findViewById(R.id.spinnerOmadas);
        String t1= spinnerOmadas.getSelectedItem().toString();

        Toast.makeText(context, t1, Toast.LENGTH_SHORT).show();

    }

}