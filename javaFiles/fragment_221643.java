List<Report> filtered = list.stream().filter(report -> {
    try {
        this.checkAuthorization(report);
    } catch (AccessViolationException ex) {
        return false;
    }
    return true;
}).collect(Collectors.toList());