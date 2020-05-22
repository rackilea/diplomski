RuntimeMXBean RuntimemxBean = ManagementFactory.getRuntimeMXBean();
List<String> args=RuntimemxBean.getInputArguments();

for(int i=0;i<args.size();i++) {
    System.out.println(args.get(i)); 
}