public static void attachGivenAgentToThisVM(String pathToAgentJar) {
    try {
        String nameOfRunningVM = ManagementFactory.getRuntimeMXBean().getName();
        String pid = nameOfRunningVM.substring(0, nameOfRunningVM.indexOf('@'));
        VirtualMachine vm = VirtualMachine.attach(pid);
        vm.loadAgent(pathToAgentJar, "");
        vm.detach();
    } catch (Exception e) {
        e.printStackTrace();
    }
}