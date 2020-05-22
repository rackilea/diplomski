static <S, T> Callback<B<S, ?>, C<S, ?>> disentangleCallback(
        Callback<B<S, T>, C<S, T>> callback
) {
    @SuppressWarnings("unchecked") //it's okay for the two captures not to match
    final Callback<B<S, ?>, C<S, ?>> withWidenedTypes =
            (Callback<B<S, ?>, C<S, ?>>)(Callback<?, ?>)callback;
    return withWidenedTypes;
}