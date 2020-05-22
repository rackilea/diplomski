List<TargetData> targetDatas = new ArrayList<>();

sourceDatas.stream().collect(Collectors.groupingBy(item -> item.getQuestion()))
    .forEach((question, itemList) -> {
        TargetData targetData = new TargetData();
        targetData.setQuestion(question);
        List<String> options = itemList.stream().map(SourceData::getOption).collect(Collectors.toList());
        targetData.setOptions(options);
        targetDatas.add(targetData);
    });