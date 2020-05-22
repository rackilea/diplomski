int ret = -1;
try {
    if (v == 1) {
        ret = 3;
    }
    else if (v == 3) {
        ret = x + 2;
    }
}
finally {
    System.out.println("The value of ret is " + ret);
}
return ret;