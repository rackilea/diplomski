class Parent
    {
        interface myP{
            public int good();
            public int good2();
            public int good3();
        }

    }

class Child extends Parent
    {
      interface myC extends Parent.myP{
            public int good();
            public int NOTgood();
        }
    }