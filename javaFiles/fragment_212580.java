Object flags = ManagementFactory.getPlatformMBeanServer().invoke(
    ObjectName.getInstance("com.sun.management:type=DiagnosticCommand"),
    "vmFlags", new Object[] { null }, new String[] { "[Ljava.lang.String;" });
for(String f: ((String)flags).split("\\s+"))
    if(f.contains("GC")) System.out.println(f);
for(GarbageCollectorMXBean gc: ManagementFactory.getGarbageCollectorMXBeans())
    System.out.printf("%-20s%s%n", gc.getName(), Arrays.toString(gc.getMemoryPoolNames()));