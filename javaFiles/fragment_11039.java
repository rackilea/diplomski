class fileObj implements Comparable<fileObj>

@Override
    public int compareTo(fileObj arg0) {

        if(this.diffSeconds > arg0.diffSeconds )
        return 0;
        else return 1;
    }