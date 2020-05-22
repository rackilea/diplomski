public static Result outputPostParams(){
    Map<String,String[]> params = request().body().asFormUrlEncoded();
    StringBuilder sb = new StringBuilder();
    for(String s: params.keySet()){
        sb.append(s).append("\n");
        for(String subs:params.get(s)){
            sb.append("- ").append(subs).append("\n");
        }
    }
    return ok(sb.toString());
}