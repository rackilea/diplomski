class StreamingLobBinding implements Binding<String, File> {
    
    @Override
    public void set(BindingSetStatementContext<File> ctx) {
        // Ideally: register the input stream somewhere for explicit resource management
        ctx.statement()
           .setBinaryStream(ctx.index(), new FileInputStream(ctx.value()));
    }
}