static inline bool compute_recording_non_safepoints() {
  if (JvmtiExport::should_post_compiled_method_load()
      && FLAG_IS_DEFAULT(DebugNonSafepoints)) {
    // The default value of this flag is taken to be true,
    // if JVMTI is looking at nmethod codes.
    // We anticipate that JVMTI may wish to participate in profiling.
    return true;
  }

  // If the flag is set manually, use it, whether true or false.
  // Otherwise, if JVMTI is not in the picture, use the default setting.
  // (This is true in debug, just for the exercise, false in product mode.)
  return DebugNonSafepoints;
}