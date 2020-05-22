public Scriptable jsGet_member() {
        Scriptable scope = ScriptableObject.getTopLevelScope(this);
        Member m = new Member();
        m.setParentScope(scope);
        // defineClass("Member") must have previously been called.
        m.setPrototype(ScriptableObject.getClassPrototype(scope, "Member"));
        m.defineFunctionProperties(new String[] { "toString" },
                m.getClass(), DONTENUM);
        return m;
    }