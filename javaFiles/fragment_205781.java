int thisIndex = -1;
LocalVariableAttribute lva = (LocalVariableAttribute)generateMission
    .getMethodInfo()
    .getCodeAttribute()
    .getAttribute(LocalVariableAttribute.tag);

for (int i = 0; thisIndex < 0 && i < lva.tableLength(); i++) {
    if (lva.variableName(i).equals("this"))
        thisIndex = lva.index(i);
}