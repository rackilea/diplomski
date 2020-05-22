...
public List<String> asList(){
    List<String> ret = new ArrayList<String>();
    for(double i = this.start; i <= this.end; i += this.step){
        ret.add(String.format("%.2f", i));
    }
    return ret;
}
....