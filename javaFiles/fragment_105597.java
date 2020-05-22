class ABCD implements InterA, InterB, InterC, InterD
{
   A implA;
   B implB;
   C implC;
   D implD;

   ABCD(A pimplA, B pimplB, C pimplC, D pimplD)
   {
     implA = pimplA;
     implB = pimplB;
     implC = pimplC;
     implD = pimplD;
  }


  // @overidde methods from InterA as return implA ->method();
  // @overidde methods from InterB as return implB ->method();
  // @overidde methods from InterC as return implC ->method();
  // @overidde methods from InterD as return implD ->method();
}