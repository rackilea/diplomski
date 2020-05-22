File C = B.getParentFile();

while(C != null) {
    if(A.equals(C))
        return true;

    C = C.getParentFile();
}

return false;