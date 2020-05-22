public int convertirOctetEnEntier(byte[] b){    
    int MASK = 0xFF;
    int result = 0;   
        result = b[0] & MASK;
        result = result + ((b[1] & MASK) << 8);
        result = result + ((b[2] & MASK) << 16);
        result = result + ((b[3] & MASK) << 24);            
    return result;
}