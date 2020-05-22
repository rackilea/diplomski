public class MyGame extends Acitvity{
     private W3iCurrencyListener w3iListener = new W3iListener(this);
     public static int coins = 0;
     @Override
     protected void onResume(){
         try{
             w3iInstance.redeemCurrency(this, w3iListener);
         }
         catch (Exception e){
            e.printStackTrace();
         }
     }
 }


public class W3iListener implements com.w3i.offerwall.W3iCurrencyListener{

    private Context mContext = null;

    public W3iListener(Context context){
        mContext = context;
    }   


    @Override
    public void onRedeem(List<Balance> paramList) {
            if(paramList.size()>0)
            {
                int coins = 0;
                for(int i=0; i<paramList.size(); i++){
                    coins += Integer.parseInt(paramList.get(i).getAmount());
                }
                MyGame.coins = coins + MyGame.coins;
            }
    }
}