double token[] = new double[9];

int i = 0;
while(inFile.hasNext()){
    token[i] = inFile.nextDouble();
    System.out.println(token);
    i++;
}
inFile.close();