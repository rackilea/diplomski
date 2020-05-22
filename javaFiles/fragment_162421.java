public void validateBooleanVTD2(PropertyRule prop, int i) throws XPathParseException, XPathEvalException,
        NavException {
    int n = -1;
    String xPath = prop.getEntitiesObjects().get(i).getxPath(); // eg. /people/man/attribute[not(key)]
    String propertyChecked = prop.getTag(); // eg. mandatory 
    VTDGen parseRef = new VTDGen();
    VTDGen parseTest = new VTDGen();
    parseRef.parseFile(ref, false);
    parseTest.parseFile(test, false);
    VTDNav navigateRef = parseRef.getNav();
    VTDNav navigateTest = parseTest.getNav();
    AutoPilot autopilotRef = new AutoPilot();
    AutoPilot autopilotTest = new AutoPilot();
    autopilotRef.bind(navigateRef);
    autopilotTest.bind(navigateTest);
    autopilotRef.selectXPath(xPath);
    //Instant start = Instant.now();

    while ((n = autopilotRef.evalXPath()) != -1) {
        int nameIndexRef = navigateRef.getAttrVal("name");
        String nameRef = navigateRef.toNormalizedString(nameIndexRef);
        //System.out.println(navigateTest.toString(n + 2));
        //System.out.println(navigateTest.toString(n + 1));
        AutoPilot autopilotRefTestTag = new AutoPilot();
        AutoPilot autopilotTestTestTag = new AutoPilot();
        autopilotRefTestTag.bind(navigateRef);
        autopilotTestTestTag.bind(navigateTest);
        autopilotTestTestTag.selectXPath(xPath + "[@name='" + nameRef + "'][descendant::"+propertyChecked+"]"); // property in Test
        autopilotRefTestTag.selectXPath(xPath + "[@name='" + nameRef + "'][descendant::"+propertyChecked+"]"); // property in Ref
        if(autopilotRefTestTag.evalXPathToBoolean() == true && autopilotTestTestTag.evalXPathToBoolean() == false)
        {
            System.out.println(nameRef/* +":"+navigateRef.toString(n)+":"+propertyChecked + ":Updated:"+prop.getTrue2falseValue()+":Changed From True to False:"+prop.getTrue2falseDesc()*/);
        }
        if(autopilotRefTestTag.evalXPathToBoolean() == false && autopilotTestTestTag.evalXPathToBoolean() == true)
        {
            System.out.println(nameRef/* +":"+navigateRef.toString(n)+":"+propertyChecked + ":Updated:"+prop.getFalse2trueValue()+":Changed From False to True:"+prop.getFalse2trueDesc()*/);
        }

    }


}