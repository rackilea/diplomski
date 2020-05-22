public static void PrintDFS(){
    int source = 0;
    int numberOfNodes = arr[source].length;
    int [] visited = new int[numberOfNodes];
    int v;
    stack.push(source);


    while (!stack.isEmpty()){
        v = stack.pop();
        if(visited[v]==0) {
          visited[v] = 1;
          System.out.println(v);
          for(int i=0;i<numberOfNodes;i++){
            if(arr[v][i]==1)
              stack.push(i);
          }
        }
    }
}