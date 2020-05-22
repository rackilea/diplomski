public static boolean conflictCheck(QueenNode a, QueenNode b) {
//checks for conflicts between head and all other nodes in the stack

    if (b == null){
        return false;
    }
    if (a.getRow()!=b.getRow() && a.getColumn()!=b.getColumn() && !diagonal(a,b)){
        return conflictCheck(a,b.getNext());
    }
    else {
        System.out.println("There is a conflict");
        return true;
    }
}