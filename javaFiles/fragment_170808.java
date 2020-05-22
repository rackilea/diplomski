class pawn {
      int resID = 0;

      ImageView object2;

      public pawn(int resID) {
          this.resID = resID;
          object2 = (ImageView) findViewById(resID)
      }

      public void showObj()
      {
          object2.animate().alpha(1f).setDuration(1000);//add code here to change alpha of object
      }

      public void hideObj()
      {
          object2.animate().alpha(0f).setDuration(1000);
      }
}