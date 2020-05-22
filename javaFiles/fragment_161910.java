observable.flatMapIterable(
    new Func1<ArrayList<T>, ArrayList<T>>() {
        @Override
        public ArrayList<T> call(ArrayList<T> list) {
            return list;
        }
    });