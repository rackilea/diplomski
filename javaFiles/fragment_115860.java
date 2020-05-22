class ModuleA {
    void process(){
        Connection c = getConnection();
        doA();
        new ModuleB( c ).doBs();
        new ModuleC( c ).doCs();
        doSomeMoreA();
        c.close();
    }
}