extern void *gHotSpotVMStructs;

int Agent_OnLoad(void *vm, char *options, void *reserved) {
    gHotSpotVMStructs = 0;
    return 0;
}