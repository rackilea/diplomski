ConstPool constPool = ctClass.getClassFile().getConstPool();

[...]

sb = new StringBuilder();
sb.append("new int[] { ");
for (int i : _OtherServerMissions)
    sb.append(String.format("%d,", i));
sb.deleteCharAt(sb.lastIndexOf(","));
sb.append(" };");

ctClass.addField(
        new CtField(
                HookManager.getInstance().getClassPool().get("[I"),
                "_OtherServerMissions", 
                ctClass),
        sb.toString());

int otherFieldIndex = constPool.addFieldrefInfo(constPool.getThisClassInfo(), "_OtherServerMissions", "[I");
logger.log(Level.INFO, "Added OtherFieldIndex as " + otherFieldIndex);