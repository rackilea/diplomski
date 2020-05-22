catch (Throwable th2) {
    th = th2;
    Ret2 = Ret;
    db.endTransaction();
    throw th;
}