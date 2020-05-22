// Print out all monitors that we have locked or are trying to lock
GrowableArray<MonitorInfo*>* mons = monitors();
if (!mons->is_empty()) {
  bool found_first_monitor = false;
  for (int index = (mons->length()-1); index >= 0; index--) {
    MonitorInfo* monitor = mons->at(index);
    if (monitor->eliminated() && is_compiled_frame()) { // Eliminated in compiled code
      if (monitor->owner_is_scalar_replaced()) {
        Klass* k = Klass::cast(monitor->owner_klass());
        st->print("\t- eliminated <owner is scalar replaced> (a %s)", k->external_name());
      } else {
        oop obj = monitor->owner();
        if (obj != NULL) {
          print_locked_object_class_name(st, obj, "eliminated");
        }
      }
      continue;