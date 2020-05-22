public class HomeActivity extends Activity {

 public void SomeMethod() {
        GridView gv = new GridView(this);
        gv.setOnClickListener(gridClickedListener);
    }

 private GridView.OnClickListener gridClickedListener =  new GridView.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
            }

        });
}