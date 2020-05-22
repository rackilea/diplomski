System.out.println("PRINTING VECTOR ELEMENTS:");
final Vector FinalClusters[][] = new Vector[100][100];

for (int i = 0; i < k; i++) {
    for (int j = 0; j < words / lines; j++) {
        final String tempString = String.valueOf(Clusters[i][j]);
        // NPE OCCURS IN THE LINE BELOW
        FinalClusters[i][j].add(tempString);
    }
}