// Redundant lock elimination
//
// There are various patterns of locking where we release and
// immediately reacquire a lock in a piece of code where no operations 
// occur in between that would be observable.  In those cases we can
// skip releasing and reacquiring the lock without violating any
// fairness requirements.  Doing this around a loop could cause a lock
// to be held for a very long time so we concentrate on non-looping
// control flow.  We also require that the operations are fully 
// redundant meaning that we don't introduce new lock operations on
// some paths so to be able to eliminate it on others ala PRE.  This
// would probably require some more extensive graph manipulation to
// guarantee that the memory edges were all handled correctly.
//
// Assuming p is a simple predicate which can't trap in any way and s
// is a synchronized method consider this code:
//
//   s();
//   if (p)
//     s();
//   else
//     s();
//   s();
//
// 1. The unlocks of the first call to s can be eliminated if the
// locks inside the then and else branches are eliminated.
//
// 2. The unlocks of the then and else branches can be eliminated if
// the lock of the final call to s is eliminated.
//
// Either of these cases subsumes the simple case of sequential control flow