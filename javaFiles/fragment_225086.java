public static Condition caseInsensitiveLikeRegex(Field<String> field, String regex) {
    return new CustomCondition() {
        @Override
        public void accept(Context<?> ctx) {
            if (ctx.family() == POSTGRES)
                ctx.visit(DSL.condition("{0} ~* {1}", field, DSL.val(regex));
            else
                ctx.visit(field.lower().likeRegex(regex.toLowerCase()));
        }
    }
}