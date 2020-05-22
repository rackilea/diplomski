private static JSONObject insertObj(JSONObject parent, JSONObject child){
    String parentStr = parent.toString();
    parentStr = parentStr.substring(1);//remove the opening curly bracket {
    String childStr = child.toString();
    childStr = childStr.substring(0, (childStr.length()-1));
    parentStr = childStr+","+parentStr;
    JSONObject resultObj = new JSONObject(parentStr);
    return resultObj;
}