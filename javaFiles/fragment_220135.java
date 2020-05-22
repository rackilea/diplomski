if (f.type().boxify().getTypeParameters()!=null && 
    f.type().boxify().getTypeParameters().size()==1){
        // f.type() is a list
        JType inner = f.type().boxify().getTypeParameters().get(0);
    f.init(JExpr._new(co.parent().getCodeModel()
            .ref(ArrayList.class).narrow(inner)));
}