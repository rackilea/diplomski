private readonly ISpaceProxy _proxy;
    private readonly long _leaseTime;

    public override bool Lock(Id id, long timeout)
    {
        bool locked;
        IdLockTrans lockTransTemplate = new IdLockTrans(id);
        // Assume that this is a new id.
        try
        {
            _proxy.Write(lockTransTemplate, null, _leaseTime, 0, UpdateModifiers.WriteOnly);
            locked = true;
        }
        catch (EntryAlreadyInSpaceException)
        {
            using (ITransaction tx = _proxy.CreateLocalTransaction())
            {
                try
                {
                    lockTransTemplate.Unlocked = true;
                    IdLockTrans lockTrans = _proxy.Take(lockTransTemplate, tx, timeout);
                    locked = (lockTrans != null);
                    if (lockTrans != null)
                    {
                        lockTrans.Unlocked = false;
                        _proxy.Write(lockTrans, tx, _leaseTime, 0, UpdateModifiers.WriteOnly);
                    }
                    tx.Commit();
                }
                catch
                {
                    tx.Abort();
                    throw;
                }
            }
        }
        return locked;
    }

    public override void Unlock(Id lockedId)
    {
        IdLockTrans lockTrans = new IdLockTrans(lockedId);
        lockTrans.Unlocked = true;
        try
        {
            _proxy.Update(lockTrans, null, _leaseTime, 0, UpdateModifiers.UpdateOnly);
        }
        catch (EntryNotInSpaceException)
        {
            throw new Exception("IdLockTrans for " + lockTrans.ID
                + " not found on Unlock. Lock time exceeded lease time.");
        }
    }