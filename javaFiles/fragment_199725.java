public static void main(String[] args) {
    String s = "{id=1111, company=A Sample Company}";
    s=s.replaceAll("\\{|\\}", "");
    Map<String, String> hm = new HashMap<String, String>();
    String[] entrySetValues = s.split(",");
    for(String str : entrySetValues){
        String[] arr = str.trim().split("=");
        hm.put(arr[0], arr[1]);
    }
    System.out.println(hm);
}

{id=1111, company=A Sample Company}