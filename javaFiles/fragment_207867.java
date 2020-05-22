public static void main(String[] args) {
    RestrictedValidation validation = new RestrictedValidation();
    validation.method1(); //compiler error
    validation.method2(); //compiler error
    validation.method3(); //success
    validation.method4(); //compiler error
}