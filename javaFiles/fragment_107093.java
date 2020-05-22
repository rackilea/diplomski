3413      OSThreadContendState osts(Self->osthread());
3414      ThreadBlockInVM tbivm(jt);
3415
3416      Self->set_current_pending_monitor(this);
3417
3418      // TODO-FIXME: change the following for(;;) loop to straight-line code.
3419      for (;;) {
3420        jt->set_suspend_equivalent();
3421        // cleared by handle_special_suspend_equivalent_condition()
3422        // or java_suspend_self()
3423
3424        EnterI (THREAD) ;
3425
3426        if (!ExitSuspendEquivalent(jt)) break ;
3427
3428        //
3429        // We have acquired the contended monitor, but while we were
3430        // waiting another thread suspended us. We don't want to enter
3431        // the monitor while suspended because that would surprise the
3432        // thread that suspended us.