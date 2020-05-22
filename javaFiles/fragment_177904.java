package some_package;

public class aif extends OneArgFunction{

    public aif() {
    }

    @Override
    public LuaValue call(LuaValue env) {
        Globals globals = env.checkglobals();
        LuaTable aif = new LuaTable();
        aif.set("foo", new foo());
        env.set("aif", aif);
        globals.package_.loaded.set("aif", aif);
        return aif;
    }

    //the rest contains the implementations of java functions
}