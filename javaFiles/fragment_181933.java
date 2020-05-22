@Override
public void setBinaryStream(int parameterIndex, InputStream x, int length) {
    if (x == null) {
        setNull(parameterIndex);
    } else {
        ServerPreparedQueryBindValue binding = getBinding(parameterIndex, true);
        this.sendTypesToServer.compareAndSet(false, binding.resetToType(MysqlType.FIELD_TYPE_BLOB, this.numberOfExecutions));
        binding.value = x;
        binding.isLongData = true;
        binding.bindLength = this.useStreamLengthsInPrepStmts.getValue() ? length : -1;
    }
}