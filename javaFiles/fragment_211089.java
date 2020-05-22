public class MyActivity implements DialogFragmentListener {
            ...
            @Override
            public void onReturnValue(String returnVal) {
                Log.d("onReturnValue", "Got value " + returnVal+ " back from Dialog!");
            }
        }