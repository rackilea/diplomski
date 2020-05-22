List<String> cmdList = new ArrayList<String>();
cmdList.add("/Users/my/path/to/test.sh");
for(Map.Entry entry : map.entrySet()) {
    cmdList.add(entry.getKey().toString());
    cmdList.add(entry.getValue().toString());
}
Process process = Runtime.getRuntime().exec(cmdList.toArray(new String[cmdList.size()]));