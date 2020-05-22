if (IBar* pBar = dynamic_cast<IBar*>(pFoo)) {
    // Do stuff using pBar here
    pBar->endWorldHunger();
} else {
    // Object doesn't support the interface: degrade gracefully
    pFoo->grinStupidly();
}