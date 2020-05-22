@Override
public int getChildTypeCount(){
    return 2;
}

@Override
public int getChildType(final int groupPosition, final int childPosition){
    if (childPosition == _listDataChild.get(groupPosition).size() - 1){
        return 1;
    }else{
        return 0;
    }
}