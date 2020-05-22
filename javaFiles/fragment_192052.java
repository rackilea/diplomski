static int animalHeads(int heads, int legs) 
{
    if (heads * 2 == legs) { // only chickens are left
        return 0;
    }
    return 1 + animalHeads(heads - 1, legs - 4);
}