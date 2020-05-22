> db.currentOp
function ( arg ){
    var q = {}
    if ( arg ) {
        if ( typeof( arg ) == "object" )
            Object.extend( q , arg );
        else if ( arg )
            q["$all"] = true;
    }
    return this.$cmd.sys.inprog.findOne( q );
}
>