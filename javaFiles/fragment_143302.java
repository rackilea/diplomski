//This is Application Trun. You may add some delay with progress bar
new Handler().postDelayed(new Runnable() {
@Override
public void run() {
          //This will execute after 3 sec
          d=random.nextInt(6)+1;
      diceno.setText(String.valueOf(d));
      calculateDiceno();
    }
}, 3000);  // 3000 means set 3 sec delay.