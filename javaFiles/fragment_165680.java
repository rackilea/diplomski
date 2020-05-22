private void serializePrefix (Node t, StringBuilder str, String sep){
    int ID = 1;
    if (t == null)
        // do nothing!
        // str.append(")");
    else{
        str.append("(" + t.data.toString() );
        str.append(sep);

        //this is the problem part, for example for node number 1:
        serializePrefix (t.left, str, sep); //this writes ")" first time
        serializePrefix (t.right, str, sep); //this writes ")" second time

        //close opened bracket
        str.append(")");
    }

    ID++;

}