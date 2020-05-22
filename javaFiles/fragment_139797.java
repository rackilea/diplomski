public class News {

    String id;

    @Override
    public boolean equals(Object o) {
        if(o instanceof News){
           News other = (News) o;
           return this.id.equals(other.id);
        }else{
           return false;
        }
    }
}