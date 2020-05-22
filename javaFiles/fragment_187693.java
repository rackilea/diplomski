int j = 0;
for (int i = 0; i < inventoryBook.length; i++) 
{
    if (inventoryBook[i] != null) {
        if (inventoryBook[i].getISBN() != itemDelete.getISBN()) 
        {
            tempBook[j] = inventoryBook[i];
            j++;
        }
    }
}