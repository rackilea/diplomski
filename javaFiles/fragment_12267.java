List<Parameter> Params = new ArrayList<Parameter>();

    Parameter Param = new Parameter();
    Param.setParameterName("Customer");
    Param.setParameterValue("ABC");
    Params.add(Param);

    Param = new Parameter();
    Param.setParameterName("Local");
    Param.setParameterValue("USA");
    Params.add(Param);

    Document doc = GetWebServiceData("GetTickets", Params);