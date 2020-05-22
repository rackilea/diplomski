interface CommandVisitor {
    void visit(SetCommand1 cmd);
    void visit(SetCommand2 cmd);
}
interface Command {
    void accept(CommandVisitor v);
}
class SetCommand1 : Command {
    public void accept(CommandVisitor v) {v.visit(this);}
}
class SetCommand2 : Command {
    public void accept(CommandVisitor v) {v.visit(this);}
}