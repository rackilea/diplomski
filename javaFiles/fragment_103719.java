int [] a ={1 , 3 , 5 , 7 , 9 };
int [] b ={5 , 4 , 7 , 8 , 10 };


Triplets [] tripletses = new Triplets[5];

for (int i = 0 ; i < tripletses.length ; i++){
    tripletses[i] = new Triplets();
    tripletses[i].a = a[i];
    tripletses[i].b = b[i];
    tripletses[i].c = tripletses[i].b - tripletses[i].a + 1;
}