int m = minute;
int s = second;

for (int i = hour; i < 24; i++) {
    for (int j = m; j < 60; j++) {
        for (int k = s; k < 60; k++) {
            ....
        }
        s = 0;
    }
    m = 0;  
}