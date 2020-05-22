if (rpcRequest != null)
{
  return RPCCopy.getInstance().encodeResponseForFailure(null, ex, rpcRequest.getSerializationPolicy());
}
else
{
    return RPCCopy.getInstance().encodeResponseForFailure(null, ex);
}