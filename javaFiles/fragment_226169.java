public class YourAppService
{
    public YourAppService(ISomeRepository repos)
    {
    }

    public IList<UserDto> ListUsers(string sortColumn = "", bool ascending = true, int pageNumber = 1, pageSize = 30)
    {
        var querySettings = new QuerySettings(sortcolumn, ascending, pageNumber, pageSize);
        var users = _repos.FindAll(querySettings);
        return ConvertToDto(users);
    }
}