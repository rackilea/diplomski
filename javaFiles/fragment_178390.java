int total = 0;
int is_silimar = 0;
for (int i = 0; i < sizeA; i++) {
            total++;
            if (dbA.getElem(i) == dbB.getElem(i)) { //change it to ==
                is_similar ++;
            }
        }

 //don't return anything yet