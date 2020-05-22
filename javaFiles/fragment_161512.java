//Create a Underline for Console window display.
String ul = String.join("", Collections.nCopies(100, "=")) + "\n";

//Period0 To Period1 Comparison:
kldFromDoubleArrays(period0, "Period 0", period1, "Period 1");
System.out.println(ul);

//Period1 To Period2 Comparison:
kldFromDoubleArrays(period1, "Period 1", period2, "Period 2");
System.out.println(ul);

//Period2 To Period3 Comparison:
kldFromDoubleArrays(period2, "Period 2", period3, "Period 3");
System.out.println(ul);