abstract class Data<D extends Data<D, M>, M extends Msg<M, D>> {
       M msg;
       void modify( M msg ) {
           this.msg = msg;
       };
}

abstract class Msg<M extends Msg<M, D>, D extends Data<D, M>> {
    abstract D createData();

    void modifyData( D data ) {
        data.modify( (M) this ); // <- you still need to cast `this` though
    };  
}