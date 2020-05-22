@Override
public void setBytes(int parameterIndex, byte[] x) {
    if (x == null) {
        setNull(parameterIndex);
    } else {
        ServerPreparedQueryBindValue binding = getBinding(parameterIndex, false);
        this.sendTypesToServer.compareAndSet(false, binding.resetToType(MysqlType.FIELD_TYPE_VAR_STRING, this.numberOfExecutions));
        binding.value = x;
    }
}