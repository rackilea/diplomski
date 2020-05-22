public class WhyAPrints01 {
    WhyAPrints0 get;
    int a = 0;

    public WhyAPrints01(WhyAPrints0 get){
        this.get = get;
    }

    public void print(){
        a = get.getWhy();
        System.out.println(a);
    }
}