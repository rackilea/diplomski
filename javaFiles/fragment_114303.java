public class MyFileTreeWriter extends Task {
    public void execute() {
           File dirs = new File("./");
           //Alternatively, you can use apache's FileUtils directory walkers https://commons.apache.org/io/api-1.4/index.html?org/apache/commons/io/DirectoryWalker.html      

  // Psuedo code below,  uses standard javax.xml.* packages ... 
  for (String file : dirs.listFiles()){
  Element em = document.createElement("file");
  em.appendChild(document.createTextNode(file);
  rootElement.appendChild(em); 

    }
}