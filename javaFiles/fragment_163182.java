GetReportListRequest req = new GetReportListRequest();

    ArrayList<String> typeArrayList = new ArrayList<String>();
    typeArrayList.add("_GET_V2_SETTLEMENT_REPORT_DATA_XML_");

    TypeList typeList = new TypeList();
    typeList.setType(typeArrayList);

    req.setReportTypeList(typeList);