public void execute(List<String> lines){
    for(String line : lines){
        // This is a very simple way to perform the splitting. 
        // You may need to write more code based on your needs.
        String[] parts = lines.split(" ");

        if(parts[0].equalsIgnoreCase("new")){
            String id = parts[1];
            String className = parts[2];
            // Etc...
        } else if(parts[0].equalsIgnoreCase("call")){
            String id = parts[1];
            String methodName = parts[2];
            // Etc...
        }
    }
}