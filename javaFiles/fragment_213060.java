public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuilder sb=new StringBuilder(S);
        int[] offsets=new int[indexes.length];

        for(int i=0;i<indexes.length;i++){

            if(S.substring(indexes[i],indexes[i]+sources[i].length()).equals(sources[i])){
                int offset=0;
                for(int j=0;j<i;j++){
                    if(indexes[j]<indexes[i])
                    offset+=offsets[j];
                }
                sb.replace(indexes[i]+offset,indexes[i]+sources[i].length()+offset,targets[i]);
                offsets[i]=targets[i].length()-sources[i].length();

            }
        }

        return sb.toString();
    }