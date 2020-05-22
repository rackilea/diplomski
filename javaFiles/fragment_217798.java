for (int i=0; i<distances.length; i++) {
    for(int j = i+1; j<distances.length; j++)
    {
        if (distances[i] > distances[j]) 
        {
             double temp = distances[j];
             distances[j] = distances[i];
             distances[i] = temp;
        }
    }
}