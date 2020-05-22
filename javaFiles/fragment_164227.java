int n = 0;
for (int i = 0; i < test.length; i++) {
    if (test[i] != 0)
        n++;
}

int[] newArray = new int[n];
int j=0;

for (int i = 0; i < test.length; i++) {
    if (test[i] != 0)
       { 
         newArray[j]=test[i]; 
         j++;
       }
}

return newArray;