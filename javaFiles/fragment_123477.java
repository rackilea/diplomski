public class CharArrayBinding implements Binding<String, char[]> {
    //                                           ^^^^^^  ^^^^^^
    // JDBC / database type ------------------------+       |
    // user facing type     --------------------------------+

    @Override
    public void set(BindingSetStatementContext<char[]> ctx) {
        ctx.statement().setCharacterStream(
            ctx.index(), 
            new java.io.CharArrayReader(ctx.value())
        );
    }

    ...
}