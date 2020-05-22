void ReferenceProcessor::process_discovered_references(
  BoolObjectClosure*           is_alive,
  OopClosure*                  keep_alive,
  VoidClosure*                 complete_gc,
  AbstractRefProcTaskExecutor* task_executor) {
  NOT_PRODUCT(verify_ok_to_handle_reflists());

  assert(!enqueuing_is_done(), "If here enqueuing should not be complete");
  // Stop treating discovered references specially.
  disable_discovery();

  bool trace_time = PrintGCDetails && PrintReferenceGC;
  // Soft references
  {
    TraceTime tt("SoftReference", trace_time, false, gclog_or_tty);
    process_discovered_reflist(_discoveredSoftRefs, _current_soft_ref_policy, true,
                               is_alive, keep_alive, complete_gc, task_executor);
  }

  update_soft_ref_master_clock();

  // Weak references
  {
    TraceTime tt("WeakReference", trace_time, false, gclog_or_tty);
    process_discovered_reflist(_discoveredWeakRefs, NULL, true,
                               is_alive, keep_alive, complete_gc, task_executor);
  }