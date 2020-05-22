public class JobPagination extends PaginationWrapper<Job> {
    protected ArrayList<Job> getNextPage(int startRow, int pageSize) {
         return /* list from database */
    }
}

public class ContractPagination extends PaginationWrapper<Contract> {
    protected ArrayList<Contract> getNextPage(int startRow, int pageSize) {
         return /* list from database */
    }
}