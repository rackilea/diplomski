testmethod.instrument(
    new ExprEditor() {
        public void edit(Handler m)
                throws CannotCompileException
        {
            m.insertBefore("throw $1;");
        }
    }
);