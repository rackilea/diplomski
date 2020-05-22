//Now accepting in i and p
public void swap(Sort m, int i, int p) {
    m.k = m.arr[i];      
    m.arr[i] = m.arr[p]; 
    m.arr[p] = m.k;
}