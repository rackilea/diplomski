class ProxyCommand : Command {
    override fun setInputStream(`in`: InputStream) {
        TODO("not implemented")
    }

    private lateinit var inputStream: ChannelPipedInputStream
}