public void onClick(View v){

smoke.setVisibility(View.VISIBLE);
Handler delayedAction = new Handler();

delayedAction.postDelayed(new Runnable() {

public void run() {

smoke.setVisibility(View.INVISIBLE);

                }

       }, 500);

}