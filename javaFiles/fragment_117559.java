HashMap<String, List<String>> taskBook = new HashMap<>();

// read from your csv File a new Line as array containing [ task, asssignee ]
// String[] line = csvReader.read ...    
// and add it to taskBook like this:

String task = line[0];      
String assignee = line[1];

if(taskBook.containsKey(assignee)){
    List<String> taskList = taskBook.get(assignee);
    taskList.add(task);
} else {
    List<String> taskList = new ArrayList<String>();
    taskList.add(task);
    taskBook.put( assignee, taskList );
}

[...]

// then you can get all tasks of an assignee like this:
List<String> tasksOf_A = taskBook.get("A");