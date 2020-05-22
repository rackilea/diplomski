Object temp = pool[position];

for (int i = (position - 1); i >= 0; i--) {                
    array[i+1] = array[i];
}

array[0] = temp;