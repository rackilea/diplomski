while (heads < 3) {
     boolean c1 = coin1.nextBoolean();
     boolean c2 = coin2.nextBoolean();
     boolean c3 = coin3.nextBoolean();
     count++;
     heads = 0;
     heads += c1 ? 1 : 0; //incrementing heads if c1 is true
     heads += c2 ? 1 : 0;
     heads += c3 ? 1 : 0;
     if(c1 && c2 && c3){ }
     System.out.println(count + "\t" + c1 +"\t" + c2 + "\t" +c3);
}