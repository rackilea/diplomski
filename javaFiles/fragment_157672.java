long startTime = System.nanoTime();
for (int i = 0; i < 5000; i++){ 
    linked.add(testData[i]);
}
long endTime = System.nanoTime();
System.out.println("Average time: " +(endTime - startTime)/5000 );