Rule CloseElement(StringVar id) {    
    return Sequence("</", Identifier(), matchStringVar(id), '>');                               
}

Action matchStringVar(final StringVar var) {
    return new Action() {
        public boolean run(Context ctx) {
            String match = ctx.getMatch();
            return match.equals(var.get());
        }
    };
}