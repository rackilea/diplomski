public LuaValue call(LuaValue modname, LuaValue env)
{
    globals = env.checkglobals();

    env.set("assert", new _assert());
    env.set("collectgarbage", new collectgarbage());
    env.set("dofile", new dofile());
            ....

    return env;
}