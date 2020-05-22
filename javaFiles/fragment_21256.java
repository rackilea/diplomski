/**
 * Bytecode generator, calling into {@link java.lang.StringBuilder}.
 */
BC_SB,

/**
 * Bytecode generator, calling into {@link java.lang.StringBuilder};
 * but trying to estimate the required storage.
 */
BC_SB_SIZED,

/**
 * Bytecode generator, calling into {@link java.lang.StringBuilder};
 * but computing the required storage exactly.
 */
BC_SB_SIZED_EXACT,

/**
 * MethodHandle-based generator, that in the end calls into {@link java.lang.StringBuilder}.
 * This strategy also tries to estimate the required storage.
 */
MH_SB_SIZED,

/**
 * MethodHandle-based generator, that in the end calls into {@link java.lang.StringBuilder}.
 * This strategy also estimate the required storage exactly.
 */
MH_SB_SIZED_EXACT,

/**
 * MethodHandle-based generator, that constructs its own byte[] array from
 * the arguments. It computes the required storage exactly.
 */
MH_INLINE_SIZED_EXACT