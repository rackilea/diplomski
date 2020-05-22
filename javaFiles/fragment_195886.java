List<List<String>> listOfStatusList = new ArrayList<>();
listOfStatusList.add(Arrays.asList("SUCCESS"));
listOfStatusList.add(Arrays.asList("CANCELLED"));    
listOfStatusList.add(Arrays.asList("ON_HOLD","INPROGRESS"));

String someId = ...;

listOfStatusList.stream()
                .map(statusList -> reportService.getReportDetails(statusList, someId))