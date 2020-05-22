class Sorter implements Comparator<AddressResponse>{
@Override
public int compare(AddressResponse a, AddressResponse b){
    if(a.getdistanceFromThePrevious() >= b.getdistanceFromThePrevious())
        return 1;
    else if(a.getdistanceFromThePrevious() < b.getdistanceFromThePrevious())
        return -1;
}