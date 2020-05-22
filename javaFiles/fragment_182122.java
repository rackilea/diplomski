while (in > 0) // until one is smaller,
{
    ++comparissons; 
    if (a[in - 1] >= temp)   ++comparissons;
    else                     break;

    a[in] = a[in - 1];            // shift item to right
    --in;                       // go left one position           
}