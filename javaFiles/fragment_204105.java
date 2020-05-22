radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int radioButtonID) {
       //radioButtonID contains selected radio button's ID.

       case R.id.dirty:
           //do something
           break;
       case R.id.clean:
           //something else
           break;
       default:
           //default action
           break;
    }
});