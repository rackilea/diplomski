String response = ...
ValueOrError<UserEntity> valueOrError = gson.fromJson(response,
    new TypeToken<ValueOrError<UserEntity>>(){}.getType());
if (valueOrError.isError()) {
  ErrorEntity error = valueOrError.getError();
  ...
} else {
  UserEntity user = valueOrError.getValue();
  ...
}