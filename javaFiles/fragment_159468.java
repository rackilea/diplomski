for(int c=0;c<width;c++){
       for(int cc=0;cc<height;cc++){
        i = (i + 1) % s.length;
        j = (j + s[i]) % s.length;
        int temp=s[i];
        s[i]=s[j];
        s[j]=temp;
        tt = (s[i] + s[j]) % 256;
        k = s[tt];
        int R=(pixels [c][cc]&0xff0000)>>16, G=(pixels [c][cc]&0x00ff00)>>8, B=(pixels [c][cc]&0x0000ff);
        R=R ^ k;
        G=G ^ k;
        B=B ^ k;
        pixels [c][cc]=(R<<16)|(G<<8)|B;
        }
    }