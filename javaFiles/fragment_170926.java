public void round1(View v){
   if (thread != null && thread.isAlive())
   {
       thread.bRun = false;
   }
   Intent i = new Intent(Qz1.this, Qone.class);
   startActivity(i);
}