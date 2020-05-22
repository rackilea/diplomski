for (PhysicalOperator op : leaves) {
    if (!(op instanceof POStore)) {
        int errCode = 2025;
        String msg = "Expected leaf of reduce plan to " +
            "always be POStore. Found " + op.getClass().getSimpleName();
        throw new MRCompilerException(msg, errCode, PigException.BUG);
    }
}