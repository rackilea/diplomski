@SuppressWarnings("unchecked")
    HashMap teams = 
    new Gson().fromJson(
        "{'east' : { 'atlantic'  : ['bkn', 'bos', 'phi','tor', 'ny']," +
        "            'central'   : ['chi', 'cle', 'det', 'ind', 'mil']," +
        "            'southeast' : ['atl', 'cha', 'mia', 'orl', 'wsh']}," +
        " 'west' : { 'northwest' : ['den', 'min', 'okc', 'por', 'utah']," +
        "            'pacific'   : ['gs', 'lac', 'lal', 'phx', 'sac']," +
        "            'southwest' : ['dal', 'hou', 'mem', 'no', 'sa']}}",
        HashMap.class
    );