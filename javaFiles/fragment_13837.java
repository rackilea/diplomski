//you start from 3 because 1 and 2 are prime already   
int i = 3;
//you can do square check, since you would have turned off all bits before you reach n
while (i * i < n) {
        if (s.get(i)) {
            int k = 3 * i;
            while (k <= n) {
                s.clear(k);
                k += i;
            }
        }
        i++;
    }