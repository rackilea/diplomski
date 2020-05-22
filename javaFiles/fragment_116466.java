List<String> temps = new ArrayList<String>();
while (inFile1.hasNext()) {
  token1 = inFile1.next();
  temps.add(token1);

  System.out.println(token1); //Check this output. Is it a hex string?
}
inFile1.close();