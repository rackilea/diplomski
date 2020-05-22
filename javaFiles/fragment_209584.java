do{

   //your code 
     Random a = new Random();
     int testa = a.nextInt(9 - 1) + 1;
     Random b = new Random();
     int testb = b.nextInt(9 - 1) + 1;
     Random c = new Random();
     int testc = c.nextInt(9 - 1) + 1;

}
while(testa == testb || testb == testc || testa == testc);