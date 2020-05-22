enum StateA
{
       AVAILABLE , COMPLETE ;
}

class A
{
      private StateA state ;
}

enum StateB
{
     AVAILABLE_TO_PUBLIC ( StateA . AVAILABLE ) , AVAILABLE_INTERNALLY ( StateA . AVAILABLE ) , COMPLETE ( COMPLETE ) ;

     StateB ( StateA sa )
     {
          this . sa = sa ;
     }

     private StateA sa ;
}

class B
{
      private StateB state ;
}