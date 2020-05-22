static{
    libsvm.svm.svm_set_print_string_function(new libsvm.svm_print_interface() {
        @Override
        public void print(String s) {
        } // Disables svm output
    });
}