import com.sun.tools.attach.VirtualMachine;
...

    VirtualMachine vm = VirtualMachine.attach(pid);
    try {
        vm.loadAgent(agentJarPath, "");
    } finally {
        vm.detach();
    }