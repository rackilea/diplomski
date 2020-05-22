public int compareTo(Course o)
{
    if(getDepartment().compareTo(o.getDepartment()) ==0){
        if(getNumber() < o.getNumber()) return -1;
        else if(getNumber() > o.getNumber()) return 1;
        else return 0;
    }

    return getDepartment().compareTo(o.getDepartment());

}