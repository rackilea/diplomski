public class SuperList<E extends ClassA> extends ArrayList<E> {

    public SuperList<E> getSomeElements() {
        SuperList<E> resultList = new SuperList<>();
        // creating result list
        return resultList;
    }
}