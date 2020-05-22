if (super_class_index == 0) {
  check_property(class_name == vmSymbols::java_lang_Object(),
                 "Invalid superclass index %u in class file %s",
                 super_class_index,
                 CHECK_(nullHandle));
} else {