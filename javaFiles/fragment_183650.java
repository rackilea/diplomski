Random r = new Random();
int Low = 10;
int High = 100;

for(int i = 0; i < MyArray .length; i++){
        MyArray [i]  = r.nextInt(High-Low) + Low;
    }