public static long getRen9Numbers(boolean[] winChecked,
                                  boolean[] tieChecked,boolean[] lossChecked) throws Exception {
    TreeSet<Integer> first=new TreeSet<>();
    TreeSet<Integer> second=new TreeSet<>();
    TreeSet<Integer> three=new TreeSet<>();
    for(int i=0;i<winChecked.length;i++){
        if(winChecked[i]){
            first.add(i);
        }
    }
    for(int i=0;i<tieChecked.length;i++){
        if(tieChecked[i]){
            if(first.contains(i)){
                second.add(i);
            }else{
                first.add(i);
            }
        }
    }
    for(int i=0;i<lossChecked.length;i++){
        if(lossChecked[i]){
            if(first.contains(i)){
                if(second.contains(i)){
                    three.add(i);
                }else{
                    second.add(i);
                }
            }else{
                first.add(i);
            }
        }
    }
    long num=0;
    if(first.size()<9){
        num = 0;
    }else{
        if(second.size()==0){
            num= combineNum(first.size(),9).intValue();
        }else{
            if(three.size()==0){
                for(int i=0;i<=second.size();i++){
                  num=num+combineNum(second.size(),i).longValue()*
                          combineNum(first.size()-i,9-i).longValue();
                }
            }else{
                for(int i=0;i<=three.size();i++){
                    long count1=0;
                    for(int j=0;j<=second.size()-i;j++){
                        count1=count1+combineNum(second.size()-i,j).longValue()*
                                combineNum(first.size()-(j+i),9-(j+i)).longValue();
                    }
                    num=num+combineNum(three.size(),i).longValue()*count1;
                }
            }
        }
    }
    return num;
}