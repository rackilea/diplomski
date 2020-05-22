Map<String, Object> input = new HashMap<>();
    input.put("club", club);
    List<StripperBean> strippers = new ArrayList<>();
    strippers.add(new StripperBean(1,"Ashley", "Jean Grey"));
    strippers.add(new StripperBean(2,"Candice","Diana Prince"));
    strippers.add(new StripperBean(3,"Cristal","Lara Croft"));        
    input.put("strippers", strippers);
    return stripClubMapper.saveStripperDetails(input);