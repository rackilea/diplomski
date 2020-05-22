class MyObject{
    ... 
    // Collection, getter and setter omitted
    ...
    public void addAllLines(List<String> lines){
       // implementation varies depending on collection,
       // but List would simply be "this.lines.addAll(lines);" 
    }

    public List<String> getAllLines(){
       // Again, depends on the type of Collection used by 
       // this instance.
       // Probably want to return a copy if thread safety is an issue.
    }
}