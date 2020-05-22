class SO15885898 {

    private static String ValueToHex(int myInt)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toHexString(myInt & 0xff));
        if (sb.length() < 2) {
            sb.insert(0, '0'); // pad with leading zero if needed
        }
        return sb.toString();
    }

    public static void main(String[] args)
    {
        int key1=11;        
        int key2=22;        
        int key3=33;

        String value = "ABCDE";
        for(int i=0; i<value.length(); i++){
            byte bValue = value.substring(i).getBytes()[0];
            int rValue = bValue^(key1>>8);
            key1 = ((rValue+key1)*key2+key3) & 0xffff;
            System.out.print(ValueToHex(rValue));
        }
    }
}