private void printFiles(File dir) {
  Stack<File> stack = new Stack<File>();
  stack.push(dir);
  while(!stack.isEmpty()) {
    File child = stack.pop();
    if (child.isDirectory()) {
      for(File f : child.listFiles()) stack.push(f);
    } else if (child.isFile()) {
      System.out.println(child.getPath());
    }
  }
}

printFiles(new File("abc/def.ghi"));