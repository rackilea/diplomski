// Define the member variable
private CheckoutButtonListener mCheckoutListener;

@Override
public void onAttach(Context context){
    super.onAttach(context);
    try{
        mCheckoutListener = (CheckoutButtonListener) context;
    }catch(ClassCastException){
      // Handle the error silently or rethrow so usage is expected
    }
}