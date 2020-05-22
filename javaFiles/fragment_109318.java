public static void main(String args[]) {
    try {
        final Sigar sigar = new Sigar();
        final long[] processes = sigar.getProcList();
        ProcTime pt = new ProcTime();
        for (final long processId : processes) {
            try {
                ProcUtil.getDescription(sigar, processId);
                pt = sigar.getProcTime(String.valueOf(processId));
                System.out.println("---" + pt.getStartTime());
            } catch (SigarException e) {
                System.out.println("can't accessible...");
            }

        }

    } catch (SigarException ex) {
        ex.printStackTrace();
    }

}