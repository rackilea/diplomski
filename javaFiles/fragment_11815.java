for (int t = 0; t < n; t++){
        true_label = true_labels[t];
        // make new_data_elem[1..K] 
        Arrays.parallelSetAll(labels, j -> classifiers[j].predict(new_data_elem[j]));
        // using labels[j] to predict decided_label        
        IntStream.range(0, K).parallel().forEach( j ->
            classifiers[j].update(new_data_elem[j], decided_label == true_label));
}