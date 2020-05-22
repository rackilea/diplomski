public List<double[]> toListTuple(double [] array){
    List<double []> ret = new ArrayList<double[]>() ;

    double [] sublist = null;
    for(int i = 0;i<array.length;i++){
        if(sublist == null)
            sublist = new double[3];
        sublist[i%3] = array[i];
        if(i%3==2) {
            ret.add(sublist);
            sublist = null;
        }
    }

    if(sublist!=null){
        ret.add(sublist); // This means some of the last elements weren't initialized
    }
    return ret;
}