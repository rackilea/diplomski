// Default stack size on Windows is determined by the executable (java.exe
// has a default value of 320K/1MB [32bit/64bit]). Depending on Windows version, changing
// ThreadStackSize to non-zero may have significant impact on memory usage.
// See comments in os_windows.cpp.
define_pd_global(intx, ThreadStackSize,          0); // 0 => use system default
define_pd_global(intx, VMThreadStackSize,        0); // 0 => use system default