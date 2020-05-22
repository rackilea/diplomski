/*
* call whenever dialog is required in whole app in form of popup
*/
public class MyDialog implements View.OnClickListener {
  private Dialog dialog;
  private Context context;
  private TextView tvTitle;
  private TextView tvSubtitle;
  private Button bt_ok;
  private String strInvalidUserNamePass, strHeader;
  /*
    * constructor to change the text dynamically.
  */
  public MyDialog(Context context, String strHeader, String invalidUserNamePass) {
     this.context = context;
     this.strInvalidUserNamePass = invalidUserNamePass;
     this.strHeader = strHeader;
     if (context != null) {
         initDialog();
     }
 }
 /*
  * set id of all the view components and implement listeners
  */
 private void initDialog() {

    dialog = new Dialog(context, R.style.FMDialogNormal);
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
    dialog.setContentView(R.layout.dialog_validation);
    dialog.setCancelable(false);
    dialog.setCanceledOnTouchOutside(false);
    dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
    dialog.show();

    tvTitle = (TextView) dialog.findViewById(R.id.tv_title);
    tvSubtitle = (TextView) dialog.findViewById(R.id.tv_subtitle);
    tvTitle.setText(strHeader);
    tvSubtitle.setText(strInvalidUserNamePass);
    bt_ok = (Button) dialog.findViewById(R.id.bt_ok);
    bt_ok.setOnClickListener(this);

}
/*
 * Implement listener according to the views
 */
 @Override
 public void onClick(View view) {
     switch (view.getId()) {
         case R.id.bt_ok:
             dialog.dismiss();
             break;
     }
 }
 public void showDialog(){
     if(dialog!=null){
         dialog.show();
     }
 }
 public void dismissDialog(){
     if(dialog!=null && isVisible()){
         dialog.show();
     }
 }  
 public boolean isVisible() {
     if (dialog != null) {
         return dialog.isShowing();
     }
     return false;
   }
 }