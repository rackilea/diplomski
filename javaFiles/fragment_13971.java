AreaCode area(int n){
    switch (n) {
    case 7927: return AreaCode.area1;
    case 7928: return AreaCode.area2;
    case 7929: return AreaCode.area3;
    default: throw new IllegalArgumentException(String.valueOf(n));
    }
}