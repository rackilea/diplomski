Grid<Sample> datagrid;
Pagination pagination;


datagrid = new Grid<>();  
...
PaginationResource paginationResource = PaginationResource.newBuilder().setPage(1).setLimit(limit).build();
pagination = new Pagination(paginationResource);
pagination.setItemsPerPage(10, 20, 50, 100);
pagination.addPageChangeListener( event -> onPageChange(event.fromIndex(), event.toIndex()) ); 

/**
 MyResultSet is a structure containing
 - a list of <Sample> beans (accessible by getList())
 - a integer with the total number of records (accessible by getTotalnumber())
 */
private void onPageChange(int fromIndex, int toIndex) {     
        MyResultSet data = loadSampleRecords(fromIndex, toIndex);
        this.pagination.setTotalCount( data.getTotalnumber() ); 
        this.datagrid.setItems( data.getList() );
        this.datagrid.getDataProvider().refreshAll();
        this.datagrid.scrollToStart();  
    }