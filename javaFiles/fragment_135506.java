import org.joda.time.DateTime;

int a;
long startTime = null;
void setup() {
  int a = 1;
startTime = System.nanoTime();
}

void draw() {

  if (a==1) {
    System.out.println(" a is equal to 1");
  }

  else {
    long estimatedTime = System.nanoTime() - startTime;

    System.out.println(" a is not equal to 1" + "took" + estimatedTime); 
}

}