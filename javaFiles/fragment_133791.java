int pageSize = pageable.getPageSize();
    if (pageSize > pageConfig.getPageDefault()) {
        pageSize = pageConfig.getPageDefault();
    }

    Pageable pr = new PageRequest(pageable.getPageNumber(), pageSize);