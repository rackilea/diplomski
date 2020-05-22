int i;

while ((i = instr.read()) != -1) {
    osstr.write(i);
}

instr.close();
osstr.close();