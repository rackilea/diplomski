EnumOne enumOne;
    EnumTwo enumTwo = null;
    EnumTwo enumThree = null;

    switch (enumOne)
    {
       case CASE_ONE:

          nested_switch1();

       case CASE_TWO:
       case CASE_THREE:

          nested_switch2();

          break;

       default:
          break;
    }

    nested_switch1() {
          switch (enumTwo)
          {
             case A:
                enumTwo = EnumTwo.B;
                break;
             case C:
                enumTwo = EnumTwo.D;
                break;
             default:
                break;
          }

          switch (enumThree)
          {
             case AA:
                enumTwo = EnumTwo.BB;
                break;
             case CC:
                enumTwo = EnumTwo.DD;
                break;
             default:
                break;
          }

          break;
    }

nested_switch2() {
          switch(EnumTwo)
          {
             default:
                break;
          }

          switch (enumThree)
          {
             case AA:
                enumTwo = EnumTwo.XX;
                break;
             case CC:
                enumTwo = EnumTwo.YY;
                break;
             default:
                break;
          }
}