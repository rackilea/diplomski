for(RetrofitVariables item: myResponse) {
    MyRoomEntity myRoomEntity = new MyRoomEntity();
    myRoomEntity.setName( item.getName() );
    myRoomEntity.setDate( item.getDate() );
    myRoomEntity.setFrom( item.getFrom() );
    myRoomEntity.setUntil( item.getUntil() );

    myViewModel.insertDataVM( myRoomEntity );
}