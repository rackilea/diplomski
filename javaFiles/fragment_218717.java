FATFS fatFs;
FIL newFile;

// The drive number may differ 
if (f_mount(0, &fatFs) != FR_OK) {
  // Something went wrong
}

if (f_open(&newFile, "/test.txt", FA_WRITE | FA_OPEN_ALWAYS) != FR_OK) {
  // Something went wrong
}