void ObjectSynchronizer::notifyall(Handle obj, TRAPS) {
    if (UseBiasedLocking) {
       BiasedLocking::revoke_and_rebias(obj, false, THREAD);
       assert(!obj->mark()->has_bias_pattern(), "biases should be revoked by now");
    }

    markOop mark = obj->mark();
    if (mark->has_locker() && THREAD->is_lock_owned((address)mark->locker())) {
        return;
    }
    ObjectSynchronizer::inflate(THREAD,
                          obj(),
                          inflate_cause_notify)->notifyAll(THREAD);
}