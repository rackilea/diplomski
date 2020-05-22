void foo()
{
    if (!doA())
        goto exit;
    if (!doB())
        goto cleanupA;
    if (!doC())
        goto cleanupB;

    // everything succeed
    return;

cleanupB:
    undoB();
cleanupA:
    undoA();
exit:
    return;
}