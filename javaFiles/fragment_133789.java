int pageSize = pageable.getPageSize();
if (pageSize > 50) {
    pageSize = 50;
}

Pageable pr = new PageRequest(pageable.getPageNumber(), pageSize);