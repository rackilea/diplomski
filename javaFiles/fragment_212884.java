class A extends Z implements A.listenerA, B.listenerB{
     @Override
     onEventinA(){
          B fragB = (B)getSupportFragmentManager().findFragmentById(R.id.fragBid);
          if (fragB == null){
                fragB = B.newInstance();
          }
          fragB.makeChange();
      }

      onEventinB(){
          A fragA = (A)getSupportFragmentManager().findFragmentById(R.id.fragAid);
          if (fragA == null){
                fragA = A.newInstance();
          }
          fragA.makeChange();
      }
 }