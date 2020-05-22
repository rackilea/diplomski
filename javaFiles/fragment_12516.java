Resources res = getResources();
    for(Field x :R.string.class.getFields())
        if(x.getName().startsWith("ans")){
                int id = x.get(null);
                choices.add(res.getString(id));
            }