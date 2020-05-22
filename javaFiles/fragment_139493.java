// Assuming a native signature like this:
// call_native_function(MyStruct** struct_list, int count)

MyStruct.ByReference[] list = new MyStruct.ByReference[SIZE];
for (int i=0;i < list.length;i++) {
    list[i] = new MyStruct.ByReference();
    // Initialize the struct as needed
}
// Call whatever native method...
nativeLibrary.call_native_function(list, list.length);