Scanner in = new Scanner(new FileReader(fileLocation));
//fileLocation is a var for the path

MyClass [] items = new MyClass[5];

int counter = 0;
while(in.hasNextLine()) {
String x = read.next();
int y = read.nextInt();
items[counter++] = new MyClass(x, y); //args require String, int
if (counter >= 5) break;
} 

in.close();