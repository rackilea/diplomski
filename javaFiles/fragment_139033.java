int x1 = 10;
int x2 = x1;
SomeClass y1 = new SomeClass();
SomeClass y2 = y1;

y1.SomeProperty = "Fred";
Console.WriteLine(y2.SomeProperty);