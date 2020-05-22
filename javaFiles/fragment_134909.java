public Scriptable jsGet_member() {
        Scriptable scope = ScriptableObject.getTopLevelScope(this);
        Context cx = Context.getCurrentContext();
        Member m = (Member)cx.newObject(scope, "Member");
        m.defineFunctionProperties(new String[] { "toString" },
                m.getClass(), DONTENUM);
        return m;
    }