String easyPuzzle  = "630208010200050089109060030"+
                 "008006050000187000060500900"+
                 "09007010681002000502003097";

 Intent i = new Intent(this, ToClass.class);
 i.putExtra("epuzzle", easyPuzzle);
      startActivity(i);