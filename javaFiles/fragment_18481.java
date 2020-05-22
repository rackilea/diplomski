Instrumentation inst = ByteBuddyAgent.install();
ClassFileTransformer cft = agentBuilder.installOnByteBuddyAgent();
try {
 // run test
finally {
  inst.removeTransformer(cft);
}