List<CustomDataBean> result = origData.stream()
        .collect(Collectors.groupingBy(DataBean::getEmployeeId))
        .entrySet().stream()
        .map(e -> new CustomDataBean(
                e.getKey(),
                e.getValue().stream().map(DataBean::getOrg).collect(Collectors.toList()),
                e.getValue().get(0).getComments()))
        .collect(Collectors.toList());