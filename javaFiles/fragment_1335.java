public class Projekt {

public static void main(String[] args) {


    int[] tablica;
    Scanner odczyt = new Scanner(System.in);

    System.out.println("Give number of elements (max 100): ");
    int liczbaElementow = odczyt.nextInt();
    tablica = new int[liczbaElementow];


    if (liczbaElementow <= 100 && liczbaElementow > 0){

        System.out.println("Generated:");
        Random Generator = new Random();
        for (int idx = 1; idx <= liczbaElementow; ++idx){
            int randomInt = Generator.nextInt(101);
            System.out.print(" " +randomInt);
            tablica[idx-1]=randomInt;


        }

        {
            System.out.println(" ");
            System.out.print("Choose sorting method (1, 2 lub 3):");
        }
        Scanner odczyt2 = new Scanner(System.in);
        int ktoresort = odczyt2.nextInt();

        switch (ktoresort) {
            case 1: System.out.println("SORT 1");
                bubbleSort(tablica);
            break;
            case 2: System.out.println("SORT 2");
                insertionSort(tablica);
            case 3: System.out.println("SORT 3");
                shelSort(tablica);
                break;
            default:  System.out.println("incorrect value");
                break;
        }

        System.out.println(Arrays.toString(tablica));
        odczyt2.close();
    }
    else if (liczbaElementow==0) {
        System.out.println("entered 0");
    }

    else{
        System.out.println("value is biger than 100");
    }
}


public static void bubbleSort( int [ ] num )
{
    int j;
    boolean flag = true;   // set flag to true to begin first pass
    int temp;   //holding variable

    while ( flag )
    {
        flag= false;    //set flag to false awaiting a possible swap
        for( j=0;  j < num.length -1;  j++ )
        {
            if ( num[ j ] < num[j+1] )   // change to > for ascending sort
            {
                temp = num[ j ];                //swap elements
                num[ j ] = num[ j+1 ];
                num[ j+1 ] = temp;
                flag = true;              //shows a swap occurred
            }
        }
    }
}


public static void insertionSort( int [ ] num)
{
    int j;                     // the number of items sorted so far
    int key;                // the item to be inserted
    int i;

    for (j = 1; j < num.length; j++)    // Start with 1 (not 0)
    {
        key = num[ j ];
        for(i = j - 1; (i >= 0) && (num[ i ] < key); i--)   // Smaller values are moving up
        {
            num[ i+1 ] = num[ i ];
        }
        num[ i+1 ] = key;    // Put the key in its proper location
    }
}


public static void shelSort(int[] array) {
    int inner, outer;
    int temp;

    int h = 1;
    while (h <= array.length / 3) {
        h = h * 3 + 1;
    }
    while (h > 0) {
        for (outer = h; outer < array.length; outer++) {
            temp = array[outer];
            inner = outer;

            while (inner > h - 1 && array[inner - h] >= temp) {
                array[inner] = array[inner - h];
                inner -= h;
            }
            array[inner] = temp;
        }
        h = (h - 1) / 3;
    }
}