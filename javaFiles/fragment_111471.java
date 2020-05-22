Needs["JLink`"]
AddToClassPath["/pathTo/ij.jar","pathTo/simple.jar"];

simpleTest = LoadJavaClass["SimpleTest", StaticsVisible -> True];
output = SimpleTest`func[data, nx, ny];
Image[Partition[output, nx]]