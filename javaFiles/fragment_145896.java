double[] terms = new double[(int)numberOfTerms];
for (int i = 0; i < numberOfTerms; i++) {
   terms[i] = firstTerm + i * commonDifference;
}

System.out.println(Arrays.toString(terms));