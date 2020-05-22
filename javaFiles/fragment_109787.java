public synchronized LiveData<PagedList<CallTable>> getPagedCallLogs() {

if (pagedCallLogs!=null && pagedCallLogs.getValue()!=null)
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