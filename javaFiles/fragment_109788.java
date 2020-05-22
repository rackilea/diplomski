public synchronized LiveData<PagedList<CallTable>> getPagedCallLogs() {
if (pagedCallLogs!=null)
{
    Log.d("PagingGetData", "Done");
    return pagedCallLogs;
}
else
{
    Log.d("PagingGetData", "Null");
    return null;
}
}