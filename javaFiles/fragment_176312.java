public static ArrayList<Double> merge(ArrayList<Double> a, ArrayList<Double> b) {

    ArrayList<Double> toReturn = new ArrayList<Double>();
    int a_ = 0;
    int b_ = 0;

    for(int j = 0; j < a.size() + b.size(); j++) {
        if(a_ == a.size())
            toReturn.add(b.get(b_++));
        else if(b_ == b.size())
            toReturn.add(a.get(a_++));
        else if(a.get(a_).compareTo(b.get(b_)) < 0)
            toReturn.add(a.get(a_++));
        else
            toReturn.add(b.get(b_++));
    }

    return toReturn;
}