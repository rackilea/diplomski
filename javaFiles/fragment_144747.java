public void execute(Tuple input) {

    Object obj = input.getValueByField(Constants.FLAG);
    int flag;
    if (obj instanceof Integer){
        //
        flag = (Integer) obj;
    }
    else if (obj instanceof String){
        flag = Integer.parseInt((String) obj);

    }
    else // you are receiving something else that is neither an integer or String
    {
        throw new RuntimeException("other class type : "+obj.getClass()
                                   +"\t toString(): "+obj.toString());
        // your should be able to see this exception on Storm UI

    }

    // do your thing


}