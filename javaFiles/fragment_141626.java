public static boolean checkCircular(JSONode temp)
  {
    if(temp == null){
       return false;
    }

    ArrayList<JSONode> pNodes = temp.getChildrens();

    for (int i = 0; i < nodes.size(); i++)
    {
        if (pNodes.get(i).getString().equals(temp.getString()))
            return true;
        if(checkCircular(temp))
            return true;
    }
    return false;
  }