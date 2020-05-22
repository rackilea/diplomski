public class StatelessServiceClass{

    private Service service;

    public int sum(int a, int b){
        return service.sum(a,b);
    }

    public void setService(Service serv){
        this.service=serv;
    }

}