String[]
ls_test = "LECT-3A,instr01,Instructor 01,teacher,instr1@learnet.com,,,,male,phone,,".split(",",12);

int cont = 0;

for (String ls_pieces : ls_test)
    System.out.println("s["+(cont++)+"]"+ls_pieces);