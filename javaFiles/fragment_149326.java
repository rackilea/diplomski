boolean updateSuccess = false;
while (!updateSuccess) {
    Immutable oldValue = randomObject.getImmutable();
    Immutable newValue = oldValue.builder().setField(oldValue.getField() * 2);
    updateSuccess = randomObject.updateImmutable(oldValue, newValue);
}