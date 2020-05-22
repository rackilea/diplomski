public static int deleteSingle(long totalRows, long pageSize, int currentPage)
{
    if(totalRows==currentPage*pageSize-pageSize)
    {
        currentPage--;
    }
    return currentPage;

}