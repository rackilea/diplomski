public interface CommonFunc {
    void workerMethod();
}

private ArrayList<CommonFunc> mEntity = new ArrayList<>();

for (int i=0 ; i < mEntity.size() ; i ++=) {
    CommonFunc obj = mEntity.get(i);
    obj.workerMethod();
}