ResultGenerator<String> rgen = new ResultGenerator<String>();

rgen.AddPossibility("Red", 25);
rgen.AddPossibility("Blue", 20);
rgen.AddPossibility("Green", 30);
rgen.AddPossibility("Black", 5);
rgen.AddPossibility("White", 15);

String result = rgen.GetRandomResult();