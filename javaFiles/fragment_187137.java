public int removeElements(T val) {
    // TODO: implementar
    // Valor: 2.5 puntos
    // Complejidad esperada: O(N)
    int cantRemovidos = 0;
    for (int i = 0, j = 0; i < arr.length; i++) {
        if (val == arr[i]) {
            cantRemovidos = cantRemovidos + 1;
        } else {
            arr[j] = arr[i]; // keeping the item
            j++; // shifting second pointer
        }
    }
    size = size - cantRemovidos; // maintain size, here you can perform array shrink
    return cantRemovidos;
}