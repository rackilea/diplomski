Map<Integer, Map<Integer, String>> outer = new HashMap<Integer, Map<Integer, String>>();
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int count = Integer.parseInt(br.readLine());

Pattern splitter = Pattern.compile("\\s");

for(int i = 0; i < count; i++){
    String input[] = splitter.split(br.readLine());

    int key = Integer.parseInt(input[0]);

    Map<Integer, String> inner = outer.get(key);
    if(inner == null){
        inner = new HashMap<Integer, String>();
        outer.put(key, inner);
    }
    inner.put(Integer.parseInt(input[1]), input[2]);
}