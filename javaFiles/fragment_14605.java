public class PointList<E> {
   private List<E> dataList;

   public PointList() {
      dataList = new ArrayList<>();
   }

   public void add(E obj) {
      dataList.add(obj);
   }
}