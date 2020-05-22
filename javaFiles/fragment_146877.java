String[] names = new String[] {"Maria Carolina", "Luisa Joana", "Lara Silva", "Catarina Patricio", "Paula Castro", "fim", null, null, null};
int newLength = names.length;
for(int i = 0; i < names.length; i++) {
    if("fim".equals(names[i])) {
        newLength = i;
        break;
    }
}
String[] truncated = java.util.Arrays.copyOf(names, newLength);
System.out.println(java.util.Arrays.toString(truncated));