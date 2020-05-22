public static void main(String[] args) {

        //cmd mystring = "this is string"
        String cmd="MyString=\"this is string\"";
        String[] str=cmd.split("=");
        Vector<CMD> myCMD=new Vector<CMD>();
        CMD c = null;
        c.setVarName(str[0]);
        c.setValue(str[1]);
        myCMD.add(c);

    }