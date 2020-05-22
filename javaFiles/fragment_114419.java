// overload: same method name, but different arguments!!!
public static int getNumVowels(String[] array)
{
    int count = 0;
    for (i = 0; i < array.lenght; i ++){
        // use existing method to save code!! 
        count += getNumVowels(array[i]);
    }

    return count;
}