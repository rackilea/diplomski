interface ReplStateFacade : Remote {

    @Throws(RemoteException::class)
    fun getId(): Int

    ...
}