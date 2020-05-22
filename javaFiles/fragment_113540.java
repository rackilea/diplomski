public class Render {

    private static final String templateDir = "some/path/to/templates";
    private STGroupFile blocksGroup;
    private STGroupFile stmtGroup;

    public Render() {
        blocksGroup = new STGroupFile(Strings.concatAsClassPath(templateDir, "Blocks.stg"));
        stmtGroup = new STGroupFile(Strings.concatAsClassPath(templateDir, "Statements.stg"));
    }

    public String gen(GenType type, String name) {
        return gen(type, name, null);
    }

    /**
     * type is an enum, identifying the group template
     * name is the template name within the group
     * varMap contains the named values to be passed to the template
     */
    public String gen(GenType type, String name, Map<String, Object> varMap) {
        Log.debug(this, name);
        STGroupFile stf = null;
        switch (type) {
            case BLOCK:
                stf = blocksGroup;
                break;
            case STMT:
                stf = stmtGroup;
                break;
        }
        ST st = stf.getInstanceOf(name);
        if (varMap != null) {
            for (String varName : varMap.keySet()) {
                try {
                    st.add(varName, varMap.get(varName));
                } catch (NullPointerException e) {
                    Log.error(this, "Error adding attribute: " + name + ":" + varName + " [" + e.getMessage() + "]");
                }
            }
        }
        return st.render();
    }
}