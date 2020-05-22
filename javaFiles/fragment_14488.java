final ImageButton[] all= {btn1, btn2, btn3, btn4};
Handler handler1 = new Handler();
for (int a = 1; a<=all.length ;a++) {
    handler1.postDelayed(new Runnable() {

         @Override
         public void run() {
              ImageButton btn5 = all[random.nextInt(all.length)];
              btn5.setBackgroundColor(Color.RED);
         }
         }, 1000 * a);
    } 
}