static <T> void helper(A<String, T> a) {

    Callback<B<String, T>, C<String, T>> result = a.method();

    //logic
}

...

helper(instance);