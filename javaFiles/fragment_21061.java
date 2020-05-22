public class MyAdapterObject{

    ......
    int type;

    public int getType(){ return type}
}

@Override
public int getItemViewType(int position) {
    switch(callSMSFeed.get(position).getType()){
         case someType:
              return SOME_TYPE;
         case someOtherType:
              return SOME_OTHER_TYPE;
         default:
              return DEFAULT_TYPE
    }
}