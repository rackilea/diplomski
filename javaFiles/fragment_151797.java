class BaseActivity extends Activity{
    public void spinnerItemSelectedEvent(AdapterView<?> parent, View view,
    int pos, long id){ }
} 

  class Login extends BaseActivity{
   public void spinnerItemSelectedEvent(AdapterView<?> parent, View view,
    int pos, long id){ //Local implementation of the function}
}

class LayoutBuilder {
private BaseActivity objActivity;

}