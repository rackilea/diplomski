BufferedImage tex;
float[] interpol;
int size;
float[] noise;
float[] workSet;
float r1,g1,b1,r2,g2,b2;
int octaves=4;
int octaveOffset=2;
public void init(int size)
{
    this.size=size;
    tex=new BufferedImage(size,size,BufferedImage.TYPE_INT_ARGB);
    interpol=new float[size];
    workSet=new float[size*size];
    noise=new float[size*size];
    float smult=(float) (Math.PI/size);
    for(int i=0;i<size;i++)
    {
        interpol[i]=(1+(float) Math.cos(i*smult))/2;
    }
    r1=255;
    g1=255;
    b1=255;
    r2=0;
    g2=0;
    b2=0;
}

public void generate()
{
    Random r=new Random();
    int[] pix=((DataBufferInt)(tex.getRaster().getDataBuffer())).getData();
    int totalSize=size*size;
    for(int i=0;i<totalSize;i++)
    {
        noise[i]=0.5f;
    }
    float[] randoms=new float[(size+1)*(size+1)];
    int scale=size>>octaveOffset;
    float max=0.50f;
    for(int oct=0;oct<octaves;oct++)
    {
        int randsPerLine=size/scale+1;
        int rands=randsPerLine*randsPerLine;
        for(int i=0;i<rands;i++)
        {
            randoms[i]=max*(r.nextFloat()-0.5f);
        }
        for(int i=0;i<totalSize;i++)
        {
            int y=(i/size)/scale;
            int suby=(i/size)%scale;
            int x=(i%size)/scale;
            int subx=(i%size)%scale;
            float intp=interpol[subx*(size/scale)];
            float colorA=randoms[y*randsPerLine+x]*intp+(1-intp)*randoms[y*randsPerLine+x+1];
            float colorB=randoms[(1+y)*randsPerLine+x]*intp+(1-intp)*randoms[(1+y)*randsPerLine+x+1];
            intp=interpol[suby*(size/scale)];
            workSet[i]=colorA*intp+(1-intp)*colorB;
        }

        for(int i=0;i<totalSize;i++)
        {
            noise[i]+=workSet[i];
        }
        max/=2;
        scale/=2;
    }
    for(int i=0;i<totalSize;i++)
    {
        int red=(int) (r1*noise[i]+r2*(1-noise[i]));
        int g=(int) (g1*noise[i]+g2*(1-noise[i]));
        int b=(int) (b1*noise[i]+b2*(1-noise[i]));
        pix[i]=(255<<24)+(red<<16)+(g<<8)+b;
    }
}