List<List<String>> list = new ArrayList<List<String>>();

List<String> item;
list.add(item = new ArrayList<String>());
item.add("foo1"); 
item.add("bar1");

list.add(item = new ArrayList<String>());
item.add("foo2"); 
item.add("bar2");

List<String> [] arr = list.toArray(new ArrayList<String>(list.size()));

int maxSize = -1;
for(int a=0;a<arr.length;a++)
    if(maxSize < arr[a].size())
        maxSize = arr[a].size();

String [][] arr2 = new String[arr.length][maxSize];
for(int a=0;a<arr.length;a++)
    arr2[a] = arr[a].toArray(new String[maxSize]);

System.out.println(arr2);