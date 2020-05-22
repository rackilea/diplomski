import java.lang.management.ManagementFactory
import sun.jvmstat.monitor.*;

name = ManagementFactory.runtimeMXBean.name
pid  = name[0..<name.indexOf('@')]
vmId = new VmIdentifier(pid)
vm   = MonitoredHost.getMonitoredHost(vmId).getMonitoredVm(vmId, 0)

println 'Y count :' + vm.findByName('sun.gc.generation.0.spaces').longValue()
println 'O count :' + vm.findByName('sun.gc.generation.1.spaces').longValue()