@Override
public Comparator<MyDataClass> getSortObjectClass() {
    return new Comparator<MyDataClass> {
        @Override
        public int compare(MyDataClass lhs, MyDataClass rhs)  {
            return lhs.seqNo - rhs.seqNo;
        }
    };
}