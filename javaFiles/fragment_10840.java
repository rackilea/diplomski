public Page<AirworthinessDirective> formPagedAds(int pg, List<AirworthinessDirective> ads) {
        ads.sort(
                Comparator
                .comparing(AirworthinessDirective::isCancelled)
                .thenComparing(AirworthinessDirective::getIssueNumber)
        );

        Pageable pageable = PageRequest.of(pg, 10, Sort.unsorted());
        int start = Math.toIntExact(pageable.getOffset());
        int end = (start + pageable.getPageSize()) > ads.size() ? ads.size() : (start + pageable.getPageSize());
        return new PageImpl<>(ads.subList(start, end), pageable, ads.size());
    }