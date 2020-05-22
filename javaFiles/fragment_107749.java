private ArrayList<TextView> test = new ArrayList<>();
public void showConsumption(){

        if(calc.getBeerCount() < 100000) {
            String convert = Integer.toString(calc.getBeerCount());
            for (int i = 0; i < convert.length(); i++) {
                test.get(i).setText(Character.toString(convert.charAt(i)));
            }
        }else{
            txtAlcLvl.setText("For sure! Do you coun't annually?");
        }
    }
}