//while loop reads each character into stringbuilder
while(true){
c = isr.read();
if (c == -1) { break; }
sb.append((char) c);
}