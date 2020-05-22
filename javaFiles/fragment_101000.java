for ( i = 0; i <= limit; i++) {
    result = subArrayAppearsAt(array, subArray, i );

    if (result==true)
        return i;
}
return -1;